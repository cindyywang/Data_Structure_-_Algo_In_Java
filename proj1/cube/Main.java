package cube;
// package is a folder of files all .java


import java.util.Observer;
//lib of code
import java.util.Observable;
import java.util.Random;

/** Main class for the Cube puzzle.
 *  @author P. N. Hilfinger. */
public class Main implements Observer {
    // not specfic as the main method

    /** Present cube puzzles, according to options given in ARGS. */
    public static void main(String... args) {
        new Main().run();
    }
    // new run Q?

    /** Set up and monitor cube puzzles until exited. */
    private void run() {
        _model = new CubeModel();
        // the cube
        _board = new CubeGUI("Cube", _model);
        // 4*4
        _side = 4;
        // 4*4
        initPuzzle();
        _board.addObserver(this);
        _board.display(true);
    }

    //row0 =  0;
    //col0 = 0;
    //painted = new boolean[size][size];
    //Random x = new Random();
    // int  n = rand.nextInt(50) + 1;
        /*for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                painted[i][j] = x.nextBoolean();
            }
        }

        //painted[0][0] = true;
        //System.out.println("set oo to true" + painted[0][0]);
        //painted = {{Random.nextBoolean, }
        // ramdomly assigned square to be painted
        //painted[]
        facePainted = new boolean[6];
        for( int i = 0; i < 6; i++)
        {
            facePainted[i] = false;
        }

        // for cube

        col0 = x.nextInt(size);
        row0 = x.nextInt(size);

        while(painted[row0][col0] == true)
        {
            col0 = x.nextInt(size);
            row0 = x.nextInt(size);
        }
        */

        /*do
        {
            col0 = x.nextInt(size);
            // nextInt goes from 0 to 3, max 4 is not inclusive

            row0 = x.nextInt(size);
        }while((painted[row0][col0] == true) );*/

    //System.out.println("00 end" + painted[0][0]);

    /** Initialize model to a random configuration on a grid with SIDE
     *  rows. */
    private void initPuzzle() {
        // FIXME
        boolean[][] gridPaint = new boolean[_side][_side];
        for (int i = 0; i < _side; i++) {
            for (int j = 0; j < _side; j++) {
                gridPaint[i][j] = _random.nextBoolean();
            }
        }
        boolean[] cubePaint = new boolean[6];
        for (int i = 0; i < 6; i++) {
            cubePaint[i] = _random.nextBoolean();
        }
        int rowCube, colCube;
        do {
            rowCube = _random.nextInt(_side);
            colCube = _random.nextInt(_side);

        } while (gridPaint[rowCube][colCube]);
        _model.initialize(_side, rowCube, colCube, gridPaint, cubePaint);
        _done = false;
    }

    @Override
    public void update(Observable obs, Object arg) {
        switch ((String) arg) {
            case "click":
                if (_done) {
                    return;
                }
                try {
                    _model.move(_board.mouseRow(), _board.mouseCol());
                    if (_model.allFacesPainted()) {
                        _done = true;
                        _board.message("", "Finished in %d moves.%n",
                                       _model.moves());
                    }
                } catch (IllegalArgumentException excp) {
                    /* Ignore IllegalArgumentException */
                }
                break;
            case "New":
                initPuzzle();
                break;
            case "Seed...":
                _random.setSeed((Long) _board.param());
                break;
            case "Size...":
                _side = (Integer) _board.param();
                initPuzzle();
                break;
            case "Quit":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /** Current board size. */
    private int _side;
    /** The current cube puzzle. */
    private CubeModel _model;
    /** GUI displaying puzzles. */
    private CubeGUI _board;
    /** True iff current puzzle is solved. */
    private boolean _done;
    /** PRNG for choosing initial positions. */
    private Random _random = new Random();

}
