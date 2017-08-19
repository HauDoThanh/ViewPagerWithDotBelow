package com.haudo.hoctienganh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<String> arr;
    List<String> arrAnswer;
    List<Integer> arrIndex;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webShow);

        int length = content.length();
        Random random = new Random();

        arrAnswer = new ArrayList<>();
        arrIndex = new ArrayList<>();

        //String[] xx = content.split("Voice1|Voice2");

        String[] xx = content.split("\\s");

        arr = Arrays.asList(xx);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("Voice_1")) {
                arr.set(i, "</br></br>Voice_1</br></br>");
            }

            if (arr.get(i).equals("Voice_2")) {
                arr.set(i, "</br></br>Voice_2</br></br>");
            }
        }

        randomString(arr);
        String str = "<html><body><p>" + toString(arr) + "</p></body></html>";

        // Log.e("loggg", str);
        webView.loadData(str, "text/html; charset=utf-8", "utf-8");

    }

    public String toString(List<String> arr) {
        String str = "";

        for (int i = 0; i < arr.size(); i++) {
            str += arr.get(i) + " ";
        }

        return str;
    }

    public void randomString(List<String> arr) {
        Random random = new Random();
        for (int i = 0; i < arr.size() / 8; i++) {
            int index = random.nextInt(arr.size());
            Log.e("logg", "random: "  + arr.get(index));

            if (arr.get(index).equals(" ")){
                Log.e("logg", "index trang: " + index);
            }
            if (arr.get(index).contains("Voice_1") || arr.get(index).contains("Voice_2")
                    || arr.get(index).equals(" ") || arr.get(index).contains("<input")) {
                index = random.nextInt(arr.size());
                Log.e("logg", "random lai: " + index);
            } else {
                arrAnswer.add(arr.get(index));
                arrIndex.add(index);

                arr.set(index, "<input type=\"text\" " +
                        "style=\"width:100px;" +
                        "border:none;" +
                        "outline:0;" +
                        "background:transparent;" +
                        "border-bottom:1px solid black;" +
                        "color:#0569FF;\"" +
                        "maxlength=\"30\">");

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_showAnswer) {
            Toast.makeText(this, "show answer!", Toast.LENGTH_SHORT).show();


            for (int i = 0; i < arrAnswer.size(); i++) {
                int index = arrIndex.get(i);
                arr.set(index, "<input type=\"text\" " +
                        "style=\"width:100px;" +
                        "border:none;" +
                        "outline:0;" +
                        "background:transparent;" +
                        "border-bottom:1px solid black;" +
                        "color:#FF0303;\"" +
                        "name = \"xxx\" " +
                        "value=\"" + arrAnswer.get(i) + "\"" +
                        "maxlength=\"30\">");

                Log.e("logg", arrAnswer.get(i));
            }

            String str = "<html><body><p>" + toString(arr) + "</p></body></html>";

            Log.e("loggg", str);
            webView.loadData(str, "text/html; charset=utf-8", "utf-8");

        }
        return true;
    }

    String content = "Voice_1\n" +
            "\n" +
            "Welcome to Spotlight. I'm Colin Lowther.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "And I'm Robin Basselin. Spotlight uses a special English method of broadcasting. " +
            "It is easier for people to understand, no matter where in the world they live.\n" +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "There is an ancient, Japanese story about a very special bowl." +
            " This story is from the 16th century. Toyotomi Hideyoshi was one of Japan's" +
            " military lords. He had a special bowl used for serving tea. " +
            "It was gift from a friend. And it was very important to him. " +
            "One day, Hideyoshi had a special gathering. He ordered his servant to " +
            "bring the special bowl. Suddenly, the servant dropped the bowl. " +
            "It broke into five pieces. Everyone at the gathering became very quiet. " +
            "People knew that Hideyoshi could become very angry, very quickly. " +
            "The people in the room wondered what Hideyoshi would do to the servant.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "After a minute of silence, another lord, named Hosokawa Yusai, spoke. The words he spoke were a poem he created about the situation. The poem was very funny. Everyone laughed. Hideyoshi forgot about his anger toward the servant. And the servant was saved. But what happened to the bowl? The bowl was also saved - using a special Japanese art form called Kintsukuroi. Kintsukuroi means \"fixed with gold.\" Today\\'s Spotlight is on the Japanese art of Kintsukuroi.\n" +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "The Japanese have an ancient story about how Kintsukuroi may have begun. In the 15th century, there was a military lord named Ashikaga Yoshimasa. He owned a special pottery, tea bowl from China. The stone bowl became damaged. So, he sent it back to China for repair. There, experts attached the broken parts of the bowl together with small pieces of metal. When the bowl returned to Japan, Yoshimasa was unhappy. He did not like the way it looked. Tradition says that this event encouraged Japanese artists to look for a more beautiful way to repair broken pottery.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "The art of Kintsukuroi developed over many years. It began when artists mixed gold dust with lacquer. For centuries, Japanese artists had used lacquer to make works of art more beautiful and last longer. Lacquer is a thick, wet, and sticky substance. Artist use it to create a clear, outer layer on objects made of wood, metal, or even cloth. Lacquer creates a beautiful shine and protects works of art from damage. When artists mixed lacquer with gold dust, they created a new, beautiful substance. And they could use it to paint broken pieces of pottery back together.\n" +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "Kintsukuroi is a complex process. Working with lacquer takes time and is difficult. To repair an object, an artist must use many different layers of lacquer. Each layer takes particular care to paint. And each layer takes several days to dry. When finished, the object is repaired. But it does not look like it did before it was broken. The object now contains gold lines where the original pieces of pottery broke apart.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "Some people may think that this process is not worth the effort. They may wonder why someone would value an object that has clearly been broken and repaired. The answer can be found in the Japanese philosophy of Wabi Sabi. Wabi Sabi is a complex way of seeing and understanding the world. One of the main ideas of Wabi Sabi is acceptance of things that are weak and imperfect. In Wabi Sabi, what is weak, broken or temporary is also beautiful. And humans should recognize and identify with this weakness.\n" +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "Kintsukuroi is an art form based on this kind of thought. Artists put great time, care and effort into fixing objects because they understand the beauty of brokenness. In Kintsukuroi, the gold lacquer does not hide the broken places. Instead, it causes people to notice the object's brokenness. For example, a repaired white serving bowl will have new, gold lines all over it. The lines of gold tell the story of being broken. And they create a new, more beautiful design. And after an object is repaired using kintsukurio, people considered it even more valuable.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "Another ancient, Japanese story shows this idea well. The story is from the 16th century. At this time, a Japanese tea man discovered an ancient Chinese tea jar. The jar was perfect in shape and shine. He thought the jar was the most beautiful he had ever seen. He wanted to show the jar to the famous tea master, Sen no Rikyu. So one day, the man invited Rikyu for tea. He used the jar to prepare tea for Rikyu. But to the man's surprise, Rikyu did not notice his beautiful jar. After the gathering, the man was angry. So, he threw the jar against the wall. The jar broke into many small pieces. The man's friends gathered the jar's pieces. Using the kintsukuroi process, they repaired the jar. Then, they invited Rikyu again for tea. As soon as Rikyu saw the jar, he commented on it. He declared that now, the piece was of great beauty and value.\n" +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "In this story, the jar's brokenness gave it greater value. This is also true for the bowl from the opening story. Toyotomi Hideyoshi loved his bowl. It was a valuable gift. But when artists repaired the bowl, its new design made it even more valuable. Japanese rulers used Hideyoshi's bowl for many generations. And today, it is an important cultural work of art in Japan.\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "Many people do not think of broken things as beautiful. But finding beauty in weakness is not only an idea from Japanese culture. The Christian religion is based on the idea that God uses human weakness to show his grace and power. In the Bible, there is a letter written by the Christian teacher, Paul. He talks about his own weakness. His physical condition causes him trouble and pain. He prays to God about his weakness. And he asks God to take it away. But God does not make him strong. Instead, God tells him:\n" +
            "\n" +
            "Voice 3\n" +
            "\n" +
            "\"My grace is enough for you. For my power is made perfect in weakness." +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "Like in Wabi Sabi, Christians recognize that humans are weak and imperfect. They are like broken jars. But their brokenness is not the end of the story. In kintsukuroi, the gold lacquer shows the beauty that can come through brokenness. In Christian thought, it is God's grace that does this. God is the artist who touches human weakness with his gold. His grace repairs people. And in the end, they are made more beautiful!\n" +
            "\n" +
            "Voice_2\n" +
            "\n" +
            "The writer of this program was Jen Hawkins. The producer was Michio Ozaki. " +
            "The voices you heard were from United States and the United Kingdom. " +
            "All quotes were adapted and voiced by Spotlight. You can listen to this program" +
            " again, and read it, on the internet at www.radioenglish.net. " +
            "This program is called, \"Broken Beauty." +
            "\n" +
            "Voice_1\n" +
            "\n" +
            "We hope you can join us again for the next Spotlight program. Goodbye!";

}
