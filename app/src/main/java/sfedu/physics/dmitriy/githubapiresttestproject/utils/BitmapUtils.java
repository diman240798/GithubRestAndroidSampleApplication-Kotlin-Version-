package sfedu.physics.dmitriy.githubapiresttestproject.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

import sfedu.physics.dmitriy.githubapiresttestproject.R;

public class BitmapUtils {

    public static byte[] bitmapToByte(Bitmap bitmap) {

        /*int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int size = bitmap.getRowBytes() * height;

        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        bitmap.copyPixelsToBuffer(byteBuffer);
        byte[] bytes = byteBuffer.array();*/

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();

        return bytes;
    }

    public static Bitmap byteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
       /* Bitmap bitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);
        ByteBuffer buffer = ByteBuffer.wrap(bitmapdata);
        bitmap.copyPixelsFromBuffer(buffer);*/

    }
}
