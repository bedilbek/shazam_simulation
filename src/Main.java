
import java.io.File;
import java.io.IOException;
import com.sun.media.sound.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Main {

    public static void main(String[] args) throws IOException {
	    WaveFileReader waveFileReader = new WaveFileReader();
	    WaveFloatFileReader waveFloatFileReader = new WaveFloatFileReader();

	    AudioInputStream waveAudio = null;
        AudioInputStream waveAudio1 = null;

        waveAudio = wavefile(args[0], waveAudio, waveFileReader);
        waveAudio1 = wavefloatfile(args[0], waveAudio1, waveFloatFileReader);

        if (waveAudio.available() != -1L)
        {
            byte frame[] = new byte[2];
            int i = 0;
            int frameData;
            while ((frameData = waveAudio.read(frame)) > 0)
            {
                System.out.print((int) frame[0] + " " + (int) frame[1] + " ");
                i++;
                if (i % 100 == 0)
                    System.out.println("\n");
            }
            System.out.println(i);
        }

        System.out.println("\n\n");

//        wavefile(args[1], waveAudio, waveFileReader);
//        wavefloatfile(args[1], waveAudio1, waveFloatFileReader);
//        System.out.println("\n\n");
//
//        wavefile(args[2], waveAudio, waveFileReader);
//        wavefloatfile(args[2], waveAudio1, waveFloatFileReader);
//        System.out.println("\n\n");




    }

    public static AudioInputStream wavefile(String fileName, AudioInputStream waveAudio, WaveFileReader waveFileReader) {
        try {
            waveAudio = waveFileReader.getAudioInputStream(new File(fileName));
            System.out.println("File: " + fileName);
            System.out.println("Frame Length: " + waveAudio.getFrameLength());
            System.out.println("Format: " + waveAudio.getFormat());
            System.out.println("WaveFile :" + waveAudio.toString());
            System.out.println("---------------------------------------");
        }
        catch (UnsupportedAudioFileException e)
        {
            System.out.println("First error");
            System.out.println(e.getStackTrace().toString());
        }
        catch (IOException e)
        {
            System.out.println("First error");
            System.out.println(e.getStackTrace().toString());
        }
        return waveAudio;
    }

    public static AudioInputStream wavefloatfile(String fileName, AudioInputStream waveAudio1, WaveFloatFileReader waveFloatFileReader) {
        try {
            waveAudio1 = waveFloatFileReader.getAudioInputStream(new File(fileName));
            System.out.println("File: " + fileName);
            System.out.println("Frame Length: " + waveAudio1.getFrameLength());
            System.out.println("Format: " + waveAudio1.getFormat());
            System.out.println("WaveFloatFile to string: " + waveAudio1.toString());
            System.out.println("---------------------------------------");
        }
        catch (UnsupportedAudioFileException e)
        {
            System.out.println("Second error");
            System.out.println(e.getStackTrace().toString());
        }
        catch (IOException e)
        {
            System.out.println("Second error");
            System.out.println(e.getStackTrace().toString());
        }
        return waveAudio1;
    }
}
