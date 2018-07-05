package sfedu.physics.dmitriy.githubapiresttestproject.utils;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class BitmapUtils {

    public static byte[] bitmapToByte(Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int size = bitmap.getRowBytes() * height;

        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        bitmap.copyPixelsToBuffer(byteBuffer);
        byte[] bitmapData = byteBuffer.array();

        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapData = stream.toByteArray();*/

        return bitmapData;
    }

    public static Bitmap byteArrayToBitmap(byte[] bitmapdata) {
        //return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if (bitmapdata == null)
            return null;
        Bitmap bitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        ByteBuffer buffer = ByteBuffer.wrap(bitmapdata);
        bitmap.copyPixelsFromBuffer(buffer);

        return bitmap;

    }
}
