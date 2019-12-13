package com.example.childapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Game implements Parcelable {

    private Integer _gameMode;
    private List<Shape> _shapes;
    private Integer _round;
    private Integer _score;

    protected Game(Parcel in) {

        _gameMode = in.readInt();
        _shapes = new ArrayList<>();
        in.readList(_shapes, GameScreenActivity.class.getClassLoader());
        _round = in.readInt();
        _score = in.readInt();
    }

    public Game(Integer gameMode) {

        _gameMode = gameMode;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_gameMode);
        dest.writeList(_shapes);
        dest.writeInt(_round);
        dest.writeInt(_score);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public void set_gameMode(Integer _gameMode) {
        this._gameMode = _gameMode;
    }

    public void set_round(Integer _round) {
        this._round = _round;
    }

    public void set_score(Integer _score) {
        this._score = _score;
    }

    public void set_shapes(List<Shape> _shapes) {
        this._shapes = _shapes;
    }

    Integer get_gameMode() {
        return _gameMode;
    }

    Integer get_round() {
        return _round;
    }

    Integer get_score() {
        return _score;
    }

    List<Shape> get_shapes() {
        return _shapes;
    }
}
