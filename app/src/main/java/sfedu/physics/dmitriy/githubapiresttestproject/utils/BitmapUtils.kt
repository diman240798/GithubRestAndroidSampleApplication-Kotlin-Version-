package sfedu.physics.dmitriy.githubapiresttestproject.utils

import android.graphics.Bitmap

import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

object BitmapUtils {

    fun bitmapToByte(bitmap: Bitmap): ByteArray {


        val height = bitmap.height

        val size = bitmap.rowBytes * height

        val byteBuffer = ByteBuffer.allocate(size)
        bitmap.copyPixelsToBuffer(byteBuffer)

        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapData = stream.toByteArray();*/

        return byteBuffer.array()
    }

    fun byteArrayToBitmap(bitmapdata: ByteArray?): Bitmap? {
        //return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if (bitmapdata == null)
            return null
        val bitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
        val buffer = ByteBuffer.wrap(bitmapdata)
        bitmap.copyPixelsFromBuffer(buffer)

        return bitmap

    }
}
