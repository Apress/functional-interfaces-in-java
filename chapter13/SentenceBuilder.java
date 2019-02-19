package chapter13;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.Scanner;
enum SPEECH {NOUN,VERB,PREPOSITION,ADJECTIVE,ARTICLE}

class Word
{
    String w;
    SPEECH part;
    public Word(String x, SPEECH p) { w=x; part=p;}
    @Override
    public String toString() { return w; };
}

class SentenceComponent
{
    Word current;
    Word previous;
    Word second;
    public SentenceComponent(Word c, Word p, Word s)
    {
        current = c;
        previous = p;
        second = s;
    }

    public SentenceComponent() 
    {
        current  = new Word("" ,null);
        previous = null;
        second   = null;
    }
    @Override
    public String toString() { return current.toString(); };
}

public class SentenceBuilder 
{
    static Word previous = null;
    static Word second   = null;

    public static void main(String[] args)
    {
        Supplier<SentenceComponent> keyboard = () -> {
            Scanner scan = new Scanner(System.in);
            SPEECH part = null;
            System.out.print("Enter a word (or enter .):");
            String w = scan.nextLine();
            if (!w.equals("."))
            {
                System.out.println("Enter its part of speech");
                System.out.print("0 - NOUN, ");
                System.out.print("1 - VERB, ");
                System.out.print("2 - PREPOSITION, ");
                System.out.print("3 - ADJECTIVE, ");
                System.out.print("4 - ARTICLE:");
                int p = Integer.parseInt(scan.nextLine());
                part  = SPEECH.values()[p];
            }
            Word word = new Word(w,part);
            SentenceComponent comp 
                = new SentenceComponent(word,previous,second);
            second = previous;
            previous =  word;
            return comp;
        };

        Function<SentenceComponent,
                 CompletionStage<SentenceComponent>> rule1 = x -> {
            CompletableFuture<SentenceComponent> fut 
                 = new CompletableFuture();
            SentenceComponent comp = null;
            if (x!=null)
            {
                if (x.current.part == null)
                    comp = x; 
                else if (!x.current.part.equals(SPEECH.VERB) 
                      || (x.previous == null) 
                       || x.previous.part.equals(SPEECH.NOUN))
                    comp = x;
                if (comp == null)
                    System.out.println(
            "GRAMMAR RULE 1 ERROR: VERBS CAN ONLY FOLLOW NOUNS.");
            }
            fut.complete(comp);
            return fut;
        };




        Function<SentenceComponent,
                 CompletionStage<SentenceComponent>> rule2 = x -> {
            CompletableFuture<SentenceComponent> fut 
                = new CompletableFuture();
            SentenceComponent comp = null;
            if (x!=null)
            {
                if (x.current.part == null)
                    comp = x; 
                else if ((x.previous == null) 
                      || !x.previous.part.equals(SPEECH.ADJECTIVE)
                      ||  x.current.part.equals(SPEECH.NOUN))
                    comp = x;
                if (comp == null)
                    System.out.println(
         "GRAMMAR RULE 2 ERROR: ADJECTIVES CAN ONLY PRECEDE NOUNS.");
            }
            fut.complete(comp);
            return fut;
        };

        Function<SentenceComponent,
                 CompletionStage<SentenceComponent>> rule3 = x -> {
            CompletableFuture<SentenceComponent> fut 
                 = new CompletableFuture();
            SentenceComponent comp = null;
            if (x!=null)
            {
                boolean result = true;
                if ((x.current.part != null) 
                 && (x.previous != null) && (x.second != null))
                {
                    if (x.second.part.equals(SPEECH.ARTICLE)) 
                    {
                        if (!x.previous.part.equals(SPEECH.ADJECTIVE)
                         || !x.current.part.equals(SPEECH.NOUN))
                            result = false;
                    }
                    else if ( x.previous.part.equals(SPEECH.ARTICLE) 
                         && !x.current.part.equals(SPEECH.NOUN)
                         && !x.current.part.equals(SPEECH.ADJECTIVE))
                        result = false;
                }
                if (result == false)
                {
                    System.out.println(
           "GRAMMAR RULE 3 ERROR: ARTICLES CAN ONLY PRECEDE NOUNS,");
                    System.out.println(
                    "HOWEVER, AN ADJECTIVE MAY OCCUR BETWEEN THEM.");
                }
                else
                    comp = x;
            }
            fut.complete(comp);
            return fut;
        };

        Function<SentenceComponent,
                 CompletionStage<SentenceComponent>> rule4 = x -> {
            CompletableFuture<SentenceComponent> fut 
                 = new CompletableFuture();
            SentenceComponent comp = null;
            if (x!=null)
            {
                boolean result = true;
                if ((x.current.part != null) 
                 && (x.previous != null) && (x.second != null))
                {
                    if (x.second.part.equals(SPEECH.PREPOSITION)) 
                    {
                        if (!x.previous.part.equals(SPEECH.ARTICLE) 
                         || !x.current.part.equals(SPEECH.NOUN))
                            result = false;
                    }
                    else if ( x.previous.part.equals(
                                       SPEECH.PREPOSITION) 
                          && !x.current.part.equals(SPEECH.NOUN)
                          && !x.current.part.equals(SPEECH.ARTICLE))
                        result = false;
                }
                if (result == false)
                {
                    System.out.println(
       "GRAMMAR RULE 4 ERROR: PREPOSITIONS CAN ONLY PRECEDE NOUNS,");
                    System.out.println(
                      "HOWEVER, AN ARTICLE MAY OCCUR BETWEEN THEM.");
                }
                else
                    comp = x;
            }
            fut.complete(comp);
            return fut;
        };

        SentenceComponent comp = new SentenceComponent();
        String sentence = "";
        while (!comp.current.w.equals("."))
        {
            comp = CompletableFuture.supplyAsync(keyboard)
                                    .thenCompose(rule1)
                                    .thenCompose(rule2)
                                    .thenCompose(rule3)
                                    .thenCompose(rule4)
                                    .join();
            if (comp == null)
            {
                comp = new SentenceComponent();
            }
            else
            {
                if (comp.current.w.equals(".") 
                 || (sentence.length() == 0))
                    sentence += comp.current;
                else 
                    sentence += " " + comp.current;
            }
        }
        System.out.println(sentence);
    }
}