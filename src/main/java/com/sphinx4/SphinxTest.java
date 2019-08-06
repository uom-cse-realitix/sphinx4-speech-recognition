package com.sphinx4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;


public class SphinxTest {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

//        configuration.setAcousticModelPath("file:/home/ashen/IdeaProjects/sphinx4/res/cmusphinx-en-in-5.2/en_in.cd_cont_5000");
//        configuration.setDictionaryPath("file:/home/ashen/IdeaProjects/sphinx4/res/cmusphinx-en-in-5.2/en_in.dic");
//        configuration.setLanguageModelPath("file:/home/ashen/IdeaProjects/sphinx4/res/cmusphinx-en-in-5.2/en-us.lm.bin");

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
//        InputStream stream = new FileInputStream(new File("samples/ar-03.wav"));

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        // Pause recognition process. It can be resumed then with startRecognition(false).

//        recognizer.startRecognition(stream);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }
}
