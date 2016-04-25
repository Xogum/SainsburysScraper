package gmail.uk.stephentaylor.sainsburysscraper;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A class to extract the HTML from the assets and convert to a File object.
 * The Jsoup library needs a File object for parsing.
 * @author Ste
 */

public class Opener {

    private File file;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private Context context;

    public Opener(Context context) {

        this.context = context;
        getFileAsset();
    }

    private void getFileAsset() {

        try {
            inputStream = context.getResources().openRawResource(R.raw.sourcecode);
            outputStream = new FileOutputStream(new File(context.getFilesDir() + "/source.txt"));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
            if (outputStream != null) {

                try {
                    outputStream.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
            file = new File(context.getFilesDir() + "/source.txt");
        }
    }

    public File getFile() {

        return file;
    }
}
