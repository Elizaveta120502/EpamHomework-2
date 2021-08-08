package com.epam.jwd.reader;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidFormatDataException;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.logger.LoggerProvider;


public class InputDataReader implements Readable {
    private static final String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/homework-2-epam-courses/src/main/resources/InputData.txt";

    public InputDataReader() {

    }


    @Override
    public Taper readInputDataTaper(Taper taper) throws FileNotFoundException, IOException, InvalidInputDataException, NotEnoughDataException {
        try {




            File file = new File(FILE_NAME);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("/");
                if (line.matches("[a-zA-Z]") == false) {
                    try {
                        if (split.length == 11) {
                            taper.setTaperBaseRadius(Float.parseFloat(split[0]));  //R
                            taper.setTaperHeight(Float.parseFloat(split[1]));  //H
                            taper.setTaperTrancatedRadius(Float.parseFloat(split[2]));  //r

                            LoggerProvider.getLOG().info("R = " + taper.getTaperBaseRadius());
                            LoggerProvider.getLOG().info("H = " + taper.getTaperHeight());
                            LoggerProvider.getLOG().info("r = " + taper.getTaperTrancatedRadius() + "\n");

                            taper = new Taper(taper.getTaperBaseRadius(), taper.getTaperHeight(), taper.getTaperTrancatedRadius());


                        } else {
                            LoggerProvider.getLOG().info("buffer is ready: ", bufferedReader.ready());
                            if (split.length < 11) {
                                LoggerProvider.getLOG().error(new NotEnoughDataException().notEnoughDataExceptionLOG());
                            } else {
                                LoggerProvider.getLOG().error(new InvalidInputDataException().invalidInputDataExceptionLOG());
                            }

                        }
                    } catch (NumberFormatException e) {
                        LoggerProvider.getLOG().error(new InvalidFormatDataException
                                ().InvalidInputDataExceptionLOG());
                    }
                } else {
                    LoggerProvider.getLOG().info("buffer is ready: ", bufferedReader.ready());
                    LoggerProvider.getLOG().info("Invalid line was missed");


                }
            }
        } catch (FileNotFoundException e) {
            LoggerProvider.getLOG().error("File not found");
        } catch (IOException e) {
            LoggerProvider.getLOG().error(e.getMessage());
        }


        return taper;
    }


    @Override
    public Point readInputDataPoint(Point point) throws FileNotFoundException, IOException, InvalidInputDataException, NotEnoughDataException {
        try {


            File file = new File(FILE_NAME);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("/");
                if (line.matches("[a-zA-Z]" ) == false) {
                    try {
                        if (split.length == 11) {

                            point.setAbscissaAxis1(Float.parseFloat(split[3])); //x1
                            point.setOrdinateAxis1(Float.parseFloat(split[4]));  //y1
                            point.setAbscissaAxis2(Float.parseFloat(split[5])); //x2
                            point.setOrdinateAxis2(Float.parseFloat(split[6]));  //y2
                            point.setAbscissaAxis3(Float.parseFloat(split[7])); //x3
                            point.setOrdinateAxis3(Float.parseFloat(split[8]));  //y3
                            point.setAbscissaAxis4(Float.parseFloat(split[9])); //x4
                            point.setOrdinateAxis4(Float.parseFloat(split[10]));  //y4

                            LoggerProvider.getLOG().info("x1 = " + point.getAbscissaAxis1());
                            LoggerProvider.getLOG().info("y1 = " + point.getOrdinateAxis1());
                            LoggerProvider.getLOG().info("x2 = " + point.getAbscissaAxis2());
                            LoggerProvider.getLOG().info("y2 = " + point.getOrdinateAxis2());
                            LoggerProvider.getLOG().info("x3 = " + point.getAbscissaAxis3());
                            LoggerProvider.getLOG().info("y3 = " + point.getOrdinateAxis3());
                            LoggerProvider.getLOG().info("x4 = " + point.getAbscissaAxis4());
                            LoggerProvider.getLOG().info("y4 = " + point.getOrdinateAxis4() + "\n");

                            point = new Point(point.getAbscissaAxis1(), point.getOrdinateAxis1(), point.getAbscissaAxis2(), point.getOrdinateAxis2(),
                                    point.getAbscissaAxis3(), point.getOrdinateAxis3(), point.getAbscissaAxis4(), point.getOrdinateAxis4());


                        } else {
                            LoggerProvider.getLOG().info("buffer is ready: ", bufferedReader.ready());
                            if (split.length < 11) {
                                LoggerProvider.getLOG().error(new NotEnoughDataException().notEnoughDataExceptionLOG());
                            } else {
                                LoggerProvider.getLOG().error(new InvalidInputDataException().invalidInputDataExceptionLOG());
                            }

                        }
                    } catch (NumberFormatException e) {
                        LoggerProvider.getLOG().error(new InvalidFormatDataException
                                ().InvalidInputDataExceptionLOG());
                    }
                } else {
                    LoggerProvider.getLOG().info("buffer is ready: ", bufferedReader.ready());
                    LoggerProvider.getLOG().info("Invalid line was missed");


                }
            }
        } catch (FileNotFoundException e) {
            LoggerProvider.getLOG().error("File not found");
        } catch (IOException e) {
            LoggerProvider.getLOG().error(e.getMessage());
        }


        return point;
    }


}

