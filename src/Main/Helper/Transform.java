package Main.Helper;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Transform {
    //TODO: add scale everywhere for zooming functions
    public static double scale = 1;
    //TODO: change variables to private
    public Vector2D location;           //location vector
    public Vector2D velocity;           //direction vector
    public Vector2D acceleration;       //speed at which is being moved
    public double size;                 //size of the object
    public Shape shape;                 //shape of the object

    //Constructors
    public Transform(Vector2D location, Vector2D velocity, Vector2D acceleration, float size, Shape shape){
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.size = size;
        this.shape = shape;
    }

    public Transform(Vector2D location, float size){
        this(location);
        this.size = size;
    }

    public Transform(Vector2D location){
        this.location = location.copy();
        this.velocity = new Vector2D();
        this.acceleration = new Vector2D();
    }

    public Transform(float x, float y){this(new Vector2D(x,y));}

    public Transform(){
        this(new Vector2D());
    }

    public void move(double maxSpeed){
        this.velocity.add(this.acceleration);
        this.velocity.limit(maxSpeed);
        this.location.add(this.velocity);
        this.acceleration.mult(0);
    }

    public void applyForce(Vector2D force) {
        this.acceleration.add(force);
    }

    public Transform clone(){
        Transform t = new Transform(location);
        return t;
    }

    //Getters and Setters for all variables
    public Vector2D getCenter(){
        return Vector2D.add(this.location.copy(), new Vector2D(this.getR(), this.getR()));
    }

    public Ellipse2D getCircle(){
        return new Ellipse2D.Double(this.getLocX() - this.getR(), this.getLocY() - this.getR(), this.size, this.size);
    }

    public Rectangle getRectangle(){
        Rectangle rec = new Rectangle((int)(this.location.x-(this.getR())),
                (int)(this.location.y-(this.getR())),
                (int)this.size, (int)this.size);
        return rec;
    }
    public double getR(){return this.size/2;}
    public Vector2D getLocation() {
        return this.location;
    }
    public void setLocation(Vector2D location) {
        this.location = location;
    }
    public double getLocX(){
        return this.location.getX();
    }
    public void setLocX(float x) {this.location.setX(x);}
    public double getLocY(){
        return this.location.getY();
    }
    public void setLocY(float y){
        this.location.setY(y);
    }

    public Vector2D getVelocity() {
        return this.velocity;
    }
    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public Vector2D getAcceleration() {
        return this.acceleration;
    }
    public void setAcceleration(Vector2D acceleration) {
        this.acceleration = acceleration;
    }

    public double getSize() {
        return this.size;
    }
    public void setSize(float size) {
        this.size = size;
    }

    public static double getScale() {
        return scale;
    }

    public static void setScale(double scale) {
        Transform.scale = scale;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
