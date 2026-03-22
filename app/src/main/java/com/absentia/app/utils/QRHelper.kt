package com.absentia.app.utils

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import java.util.UUID

object QRHelper {

    fun generateToken(): String = UUID.randomUUID().toString()

    fun generateQRBitmap(content: String, size: Int = 600): Bitmap? {
        return try {
            val hints = mapOf(EncodeHintType.MARGIN to 1)
            val bitMatrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints)
            val bmp = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
            for (x in 0 until size) {
                for (y in 0 until size) {
                    bmp.setPixel(x, y, if (bitMatrix[x, y]) 0xFF1565C0.toInt() else 0xFFFFFFFF.toInt())
                }
            }
            bmp
        } catch (e: WriterException) {
            null
        }
    }
}
