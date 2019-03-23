package homeworks.homework10.bodies;

import java.util.List;

public class SpellerResponse {

    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;

    public SpellerResponse() {}

    public SpellerResponse(int code, int pos, int row, int col, int len, String word, List<String> s) {
        this.code = code;
        this.pos = pos;
        this.row = row;
        this.code = col;
        this.len = len;
        this.word = word;
        this.s = s;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getS() {
        return s;
    }

    public void setS(List<String> s) {
        this.s = s;
    }
}
