package com.example.childapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Random;

/** This class is used to populate all the shapes the game will need, and load it
 *  into a data structure to be called later. There are 3 different logics used
 *  based on the game type:
 *  1- match shapes only
 *  2- match colors only
 *  3- match shapes and colors
 */
public class ShapeBuilder {

    // private member variables
    private int order;
    private String color;
    private List<Shape> shapes = new ArrayList<Shape>();

    private static final String TAG = "ShapeFactory";

    // NON-DEFAULT CONSTRUCTOR
    public ShapeBuilder(int order) {
        this.order = order;
    }

    // List GETTER
    public List<Shape> getList() {
        return shapes;
    }

    /**
     * For GAME MODE 1
     */
    private List<Shape> shapeMakerOrderOne() {
        List<Shape> list = new ArrayList<>();
        Shape shape;
        boolean isSecond = false;
        for (int i = 0; i < 4; i++) {
            // insert algorithm
            if (list.isEmpty()) {
                shape = getRandomShape();
                list.add(shape);
                isSecond = true;
            } else {
                if (isSecond) {
                    shape = getShapeCopy(list.get(0));
                    //shape.changeShapeColor(getRandomColor());
                    list.add(shape);
                    isSecond = false;
                } else {
                    shape = getRandomShape();
                    list.add(shape);
                }
            }
        }
        return list;
    }

    /**
     * For GAME MODE 2
     */
    private List<Shape> shapeMakerOrderTwo() {
        List<Shape> list = new ArrayList<>();
        Shape shape;
        boolean isSecond = false;
        for (int i = 0; i < 4; i++) {
            // insert algorithm
            if (list.isEmpty()) {
                shape = getRandomShape();
                list.add(shape);
                isSecond = true;
            } else {
                if (isSecond) {
                    shape = getRandomShape(list.get(0).getColor());
                    list.add(shape);
                    isSecond = false;
                } else {
                    shape = getRandomShape();
                    list.add(shape);
                }
            }
        }
        return list;
    }

    /**
     * For GAME MODE 3
     */
    private List<Shape> shapeMakerOrderThree() {
        List<Shape> list = new ArrayList<>();
        Shape shape;
        boolean isSecond = false;
        for (int i = 0; i < 4; i++) {
            if (list.isEmpty()) {
                shape = getRandomShape();
                list.add(shape);
                isSecond = true;
            } else {
                if (isSecond) {
                    shape = getShapeCopy(list.get(0));
                    list.add(shape);
                    isSecond = false;
                } else {
                    shape = getRandomShape();
                    list.add(shape);
                }
            }
        }
        return list;
    }

    /**
     * GET RANDOM COLOR
     */
    private SelectedColor getRandomColor() {
        Random r = new Random();
        int temp = r.nextInt(6);  // fix this
        switch (temp) {
            case 0:
                return SelectedColor.Blue;
            case 1:
                return SelectedColor.Red;
            case 2:
                return SelectedColor.Yellow;
            case 3:
                return SelectedColor.Green;
            case 4:
                return SelectedColor.Orange;
            case 5:
                return SelectedColor.Purple;
            default:
                break;
        }
        return SelectedColor.Blue;
    }


    /**
     * GET RANDOM SHAPE
     */
    private Shape getRandomShape() {
        Shape shape;
        Random r = new Random();
        int temp = r.nextInt(6);

        switch (temp) {
            case 0:
                shape = new Circle(getRandomColor());
                break;
            case 1:
                shape = new Triangle(getRandomColor());
                break;
            case 2:
                shape = new Square(getRandomColor());
                break;
            case 3:
                shape = new Star(getRandomColor());
                break;
            case 4:
                shape = new Diamond(getRandomColor());
                break;
            case 5:
                shape = new Heart(getRandomColor());
                break;
            default:
                shape = new Circle(getRandomColor());
        }
        return shape;
    }

    /**
     * GET RANDOM SHAPE
     */
    private Shape getRandomShape(SelectedColor color) {
        Shape shape;
        Random r = new Random();
        int temp = r.nextInt(6);

        switch (temp) {
            case 0:
                shape = new Circle(color);
                break;
            case 1:
                shape = new Triangle(color);
                break;
            case 2:
                shape = new Square(color);
                break;
            case 3:
                shape = new Star(color);
                break;
            case 4:
                shape = new Diamond(color);
                break;
            case 5:
                shape = new Heart(color);
                break;
            default:
                shape = new Circle(color);
        }
        return shape;
    }


    /**
     * Create a copy of a shape
     */
    private Shape getShapeCopy(Shape s) {
        Shape shape;
        Random r = new Random();
        int temp = r.nextInt(6);

        switch (s.getShape()) {
            case Circle:
                shape = (order == 1) ? new Circle(getRandomColor()) : new Circle(s.getColor());
                break;
            case Triangle:
                shape = (order == 1) ? new Triangle(getRandomColor()) : new Triangle(s.getColor());
                break;
            case Square:
                shape = (order == 1) ? new Square(getRandomColor()) : new Square(s.getColor());
                break;
            case Star:
                shape = (order == 1) ? new Star(getRandomColor()) : new Star(s.getColor());
                break;
            case Diamond:
                shape = (order == 1) ? new Diamond(getRandomColor()) : new Diamond(s.getColor());
                break;
            case Heart:
                shape = (order == 1) ? new Heart(getRandomColor()) : new Heart(s.getColor());
                break;
            default:
                shape = (order == 1) ? new Circle(getRandomColor()) : new Circle(s.getColor());
        }
        return shape;
    }



    /**
     * GET SHAPES
     */
    public List<Shape> getListofShapes() {
            switch (order) {
                case 1:
                    // two shapes must be the same
                    // first one will be the one that doesn't move.
                    shapes = shapeMakerOrderOne();
                    break;
                case 2:
                    // colors
                    shapes = shapeMakerOrderTwo();
                    break;
                case 3:
                    // shapes and colors
                    shapes = shapeMakerOrderThree();
                    break;
            }
        Log.i(TAG, "LIST size" + shapes.size());
        Log.i(TAG, "LIST contents" + shapes);

        Collections.shuffle(shapes.subList(1,4));

        Log.i(TAG, "LIST contents after shuffle" + shapes);
        return shapes;
    }

    /**
    * Returns a list of shapes from the saved array
    */
    public static List<Shape> getShapesFromJsonArray(JSONArray arr) throws JSONException {
        List <Shape> shapes = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject shp = arr.getJSONObject(i);
            SelectedColor color = SelectedColor.valueOf(shp.getString("_color"));

            switch (shp.getString("_name")) {
                case "Circle":
                    shapes.add(new Circle(color));
                    break;
                case "Triangle":
                    shapes.add(new Triangle(color));
                    break;
                case "Square":
                    shapes.add(new Square(color));
                    break;
                case "Star":
                    shapes.add(new Star(color));
                    break;
                case "Diamond":
                    shapes.add(new Diamond(color));
                    break;
                case "Heart":
                    shapes.add(new Heart(color));
                    break;
                default:
                    shapes.add(new Circle(color));
            }
        }
        return shapes;
    }



}
