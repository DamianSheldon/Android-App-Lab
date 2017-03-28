package com.example.helloworld;

/**
 * Created by dongmeiliang on 24/03/2017.
 */

public enum Layouts {
    LinearLayoutXML(0), LinearLayoutCode(1), RelativeLayoutXML(2), TableLayout(3), TableRow(4), FragmentLayout(5), ConstraintLayout(6), GridLayout(7);

    private String [] mLayoutStrings = {"Linear Layout XML", "Linear Layout Code", "Relative Layout XML", "TableLayout", "TableRow", "FragmentLayout", "ConstraintLayout", "GridLayout"};

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
            default:
                break;
        }

        return mappedClass;
    }
}
