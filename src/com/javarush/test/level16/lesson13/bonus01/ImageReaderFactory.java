package com.javarush.test.level16.lesson13.bonus01;


import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
//        ImageReader reader;
//        if (imageTypes == ImageTypes.PNG) reader = new PngReader();
//        else if (imageTypes == ImageTypes.JPG) reader = new JpgReader();
//             else  if (imageTypes == ImageTypes.BMP) reader = new BmpReader();
//                    else reader = null;
//        if (reader == null) throw new IllegalArgumentException("Неизвестный тип картинки");
//        return reader;

        switch (imageTypes)
        {
            case BMP:
                System.out.println("BMP");
                return new BmpReader();
            case JPG:
                System.out.println("JPG");
                return new JpgReader();
            case PNG:
                System.out.println("PNG");
                return new PngReader();
            default:
                System.out.println("EXCEPTION");
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
