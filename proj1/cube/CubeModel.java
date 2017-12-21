package cube;

//import java.util.Arrays;
import java.util.Observable;

//import java.util.Random;

//import static java.lang.System.arraycopy;

/** Models an instance of the Cube puzzle: a cube with color on some sides
 *  sitting on a cell of a square grid, some of whose cells are colored.
 *  Any object may register to observe this model, using the (inherited)
 *  addObserver method.  The model notifies observers whenever it is modified.
 *  @author P. N. Hilfinger
 */
public class CubeModel extends Observable {

    private int size;
    private int rowCube;
    private int colCube;
    private boolean[][] gridPainted;
    private boolean[] cubePainted;
    private int numOfMove = 0;


    /** A BLAMK CUBE!!!! puzzle of size 4. */
    public CubeModel() {
        // FIXME
        //numOfMove++;
        size = 4;
        cubePainted = new boolean[6];
        for (int i = 0; i < 6; i++) {
            cubePainted[i] = false;
        }
        gridPainted = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gridPainted[i][j] = false;
            }
        }



    }

    /** A copy of CUBE. */
    public CubeModel(CubeModel cube) {
        //numOfMove++;
        initialize(cube);
    }

    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c], and
     *  with face k painted iff FACEPAINTED[k] (see isPaintedFace).
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     *    * FACEPAINTED has length 6.
     */
    public void initialize(int side, int row0, int col0, boolean[][] painted,
                    boolean[] facePainted) {
        // FIXME
        rowCube = row0;
        colCube = col0;
        size = side;
        gridPainted = new boolean[size][size];
        cubePainted = new boolean[6];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (painted[i][j]) {
                    gridPainted[i][j] = true;
                } else {
//                    System.out.println(i);
//                    System.out.println(j);

                    gridPainted[i][j] = false;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (facePainted[i]) {
                cubePainted[i] = true;
            } else {
                cubePainted[i] = false;
            }
        }

        setChanged();
        notifyObservers();
    }

    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c].
     *  The cube is initially blank.
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     */
    public void initialize(int side, int row0, int col0, boolean[][] painted) {
        initialize(side, row0, col0, painted, new boolean[6]);
    }

    /** Initialize puzzle to be a copy of CUBE. */
    public void initialize(CubeModel cube) {
        boolean[][] puzlPaint = new boolean[cube.side()][cube.side()];
        for (int i = 0; i < cube.side(); i++) {
            for (int j = 0; j < cube.side(); j++) {
                puzlPaint[i][j] = cube.isPaintedSquare(i, j);
            }
        }
        boolean[] cubePaint = new boolean[6];
        for (int i = 0; i < 6; i++) {
            cubePaint[i] = cube.isPaintedFace(i);
        }
        initialize(cube.side(), cube.cubeRow(), cube.cubeCol(), puzlPaint, cubePaint);
        numOfMove = cube.moves();
        // FIXME
        setChanged();
        notifyObservers();
    }

    /** Move the cube to (ROW, COL), if that position is on the board and
     *  vertically or horizontally adjacent to the current cube position.
     *  Transfers colors as specified by the rules.
     *  Throws IllegalArgumentException if preconditions are not met.
     */
    public void move(int row, int col) {
        // FIXME
        CubeModel copy = new CubeModel(this);

        if ((row > -1) && (row < 4) && (col > -1) && (col < 4)) {
            if (((((row - rowCube) == 1) || ((rowCube - row) == 1))
                    && (col == colCube)) || ((row == rowCube)
                    && (((col - colCube) == 1) || ((colCube - col) == 1)))) {
                // rowCube = row;
                // colCube = col;
                if ((row - rowCube) == 1) {
                    cubePainted[4] = copy.isPaintedFace(1);
                    cubePainted[5] = copy.isPaintedFace(0);
                    cubePainted[1] = copy.isPaintedFace(5);
                    cubePainted[0] = copy.isPaintedFace(4);


                }
                if ((rowCube - row) == 1) {
                    cubePainted[1] = copy.isPaintedFace(4);
                    cubePainted[0] = copy.isPaintedFace(5);
                    cubePainted[5] = copy.isPaintedFace(1);
                    cubePainted[4] = copy.isPaintedFace(0);

                }
                if ((col - colCube) == 1) {
                    cubePainted[4] = copy.isPaintedFace(3);
                    cubePainted[3] = copy.isPaintedFace(5);
                    cubePainted[5] = copy.isPaintedFace(2);
                    cubePainted[2] = copy.isPaintedFace(4);

                }
                if ((colCube - col) == 1) {
                    cubePainted[4] = copy.isPaintedFace(2);
                    cubePainted[5] = copy.isPaintedFace(3);
                    cubePainted[2] = copy.isPaintedFace(5);
                    cubePainted[3] = copy.isPaintedFace(4);
                }
                for (int i = 0; i < cubePainted.length; i++) {
                    System.out.println(cubePainted[i]);
                }
                System.out.println("Done");

                //if (!gridPainted[row][col]) {
                // transfer the color
                rowCube = row;
                colCube = col;
                if (cubePainted[4]) {
                    if (!gridPainted[row][col]) {
                        gridPainted[row][col] = true;
                        cubePainted[4] = false;
                    }

                } else {
                    if (gridPainted[row][col]) {
                        gridPainted[row][col] = false;
                        cubePainted[4] = true;
                    }
                }

                numOfMove++;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
        setChanged();
        notifyObservers();
    }

    /** Return the number of squares on a side. */
    public int side() {
        return size; // FIXME
    }

    /** Return true iff square ROW, COL is painted.
     *  Requires 0 <= ROW, COL < board size. */
    public boolean isPaintedSquare(int row, int col) {
        return (gridPainted[row][col]); // FIXME
    }

    /** Return current row of cube. */
    public int cubeRow() {
        return rowCube; // FIXME
    }

    /** Return current column of cube. */
    public int cubeCol() {
        return colCube; // FIXME
    }

    /** Return the number of moves made on current puzzle. */
    public int moves() {
        return numOfMove; // FIXME
    }

    /** Return true iff face #FACE, 0 <= FACE < 6, of the cube is painted.
     *  Faces are numbered as follows:
     *    0: Vertical in the direction of row 0 (nearest row to player).
     *    1: Vertical in the direction of last row.
     *    2: Vertical in the direction of column 0 (left column).
     *    3: Vertical in the direction of last column.
     *    4: Bottom face.
     *    5: Top face.
     */
    public boolean isPaintedFace(int face) {
        return cubePainted[face]; // FIXME
    }

    /** Return true iff all faces are painted. */
    public boolean allFacesPainted() {
        for (int i = 0; i < 6; i++) {
            if (!cubePainted[i]) {
                return false;
            }
        }
        return true; // FIXME
    }

    // ADDITIONAL FIELDS AND PRIVATE METHODS HERE, AS NEEDED.



}
/*
Lab11
 */

/*
public abstract class Animal
{
    int size;
    String name;
    public Animal()
    {

    }
}

public class Fish extends Animal
{
    public Fish(int size String name)
    {

     super();
    }
}
 */

/*

Box<Integer> a = new Box(1);
Box<Integer> b = new Box(1);
a == b;

public boolean equals(To)
{
    compare my item w/o's item
    return 1==2;
}
 */

/*
To sort List
3 2 0 1
0 1 2 3
Fisha > Fishb
Two new interfaces: Comparable && Comparator
Collections.sort(a);
Fisha, Fishb, Fishc

Comparable:
-compareTo(T o)
return this.size-o,size
-1 this < 0
0 this == 0
1 this > 0

Collections.sort(b, new Fish())
Comparator Interface
-compare(T o1, T o2)
public class Fish(implements, comparator)
compare(____);

IDK


Java8

Higher Order function == HOF
map: square each element in a list
-have each element

define a func interface
Have class defined in this interface

 //python
 // map(square, list)
 //define square

 lambda functions
    (args) -> (return value)
    (Integer i, integer j) -> (i+j;)

 Another way for lambda:
 Method references
 Fish::getSize

 Q: let map be in an interface such that we can implement it for any class we want?
 // functional interface? line 208

 Collections.sort(b, new Fish());
 //Comparator Method
 //No longer needed, let's do Fish::compare

 (f1, f2) -> (f1.size - f.size)

 functional interface : only one method

Streams
-assembly line w/stations
independent

-intermediate: map
flatMap // look at the doc
filter // eg.filter(size == 1)
sorted// eg.sorted()// sorted(comparator)

-terminal:
//transfer the stream back to ADT
collect
for Each
reduce
allMatch, anyMatch



 method references
 READ JAVADOCS
 */
