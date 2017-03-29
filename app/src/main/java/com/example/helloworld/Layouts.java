package com.example.helloworld;

/**
 * Created by dongmeiliang on 24/03/2017.
 */

public enum Layouts {
    LinearLayoutXML(0), LinearLayoutCode(1), RelativeLayoutXML(2), RelativeLayoutCode(3), TableLayout(4), TableRow(5), FragmentLayout(6), ConstraintLayout(7), GridLayout(8);

    Layouts(int index) {

    }

    @Override
    public String toString() {
        return this.name();
    }

    public Class<?> mappedClass() {
        Class<?> mappedClass = null;

        switch (this) {
            case LinearLayoutXML:
                mappedClass = LinearLayoutXMLActivity.class;
                break;
            case LinearLayoutCode:
                mappedClass = LinearLayoutCodeActivity.class;
                break;
            case RelativeLayoutXML:
                mappedClass = RelativeLayoutXMLActivity.class;
                break;
            case RelativeLayoutCode:
                mappedClass = RelativeLayoutCodeActivity.class;
                break;
            default:
                break;
        }

        return mappedClass;
    }
}
