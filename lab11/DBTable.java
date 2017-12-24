import java.util.*;
import java.util.function.Function;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBTable<T> {
    protected List<T> entries;

    public DBTable() {
        this.entries = new ArrayList<>();
    }

    public DBTable(Collection<T> lst) {
        entries = new ArrayList<>(lst);
    }

    public void add(T t) {
        entries.add(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DBTable<?> dbTable = (DBTable<?>) o;
        return entries != null ? entries.equals(dbTable.entries) : dbTable.entries == null;

    }

    /**
     * Add all items from a collection to the table
     */
    public void add(Collection<T> col) {
        col.forEach(this::add);
    }

    /**
     * Returns a copy of the entries in this table
     */
    List<T> getEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * getOrderedBy should create a new list ordered on the results of the getter,
     * without modifying the entries.
     * @param getter Gets a field from or processes an object of type T, and returns
     *               a Comparable.
     * @param <R> The type returned by the getter method, and the type ordered on.
     * @return A List of the contents of this table, ordered by the result of the getter.
     */
    public <R extends Comparable<R>> List<T> getOrderedBy(Function<T, R> getter)
    {

        List<T> result = getEntries();

        // Solution 1 : Tedious Lambda Solution without Comparator.comparing()
        // Collections.sort(result, (e1, e2) -> getter.apply(e1).compareTo(getter.apply(e2)));

        // Solution 2 : Lambda Solution simplified with Comparator.comparing()
        Collections.sort(result, Comparator.comparing(e -> getter.apply(e)));

        // Q1 Solution 3 : stream solution with return mutated type problem with T
        /*return entries.stream()
                .map(s -> getter.apply(s))
                .sorted(R::compareTo)
                .collect(Collectors.toList());*/
        return result;

    }

    /**
     * groupByWhitelist() takes in a getter and a whitelist, and groups entries by the key given by
     * the getter as long as the key is present in the whitelist.
     * @param getter Gets a field from or process an object of type T.
     * @param whitelist A Collection of keys.
     * @param <R> The key type and return type of the getter.
     * @return A map from each key allowed to a list of the matching entries.
     * All keys present in this DB as obtained by the getter and in the whitelist are allowed.
     */
    public <R> Map<R, List<T>> groupByWhitelist(Function<T, R> getter, Collection<R> whitelist) {

        return null; // FIX ME
    }

    /**
     * Creates a DBTable that contains the elements as obtained by the getter.
     * For example, getting a DBTable of usernames would look like this:
     * DBTable<String> names = table.getSubtableOf(User::getUsername);
     */
    public <R> DBTable<R> getSubtableOf(Function<T, R> getter) {
        // Q2 doesn't work
        return entries.stream()
                .map(s -> getter.apply(s))
                .collect(Collectors.toCollection(DBTable<R>::new)); // FIX ME
    }

    public static void main(String[] args) {
        /* Basic test DB */
        DBTable<User> a = new DBTable<>(Arrays.asList(
                new User(2, "christine", ""),
                new User(4, "antares", ""),
                new User(1, "dan", ""),
                new User(1, "daniel", ""),
                new User(5, "ching", "")
        ));
        List<User> l = a.getOrderedBy(User::getUsername);
        System.out.println(l);
        DBTable<User> t = new DBTable<>(Arrays.asList(
                new User(2, "daniel", "dando@gmail.com"),
                new User(3, "matt", "italy@gmail.com"),
                new User(1, "sarahjkim", "potato@potato.com"),
                new User(1, "alanyao", "potato@cs61bl.org")
        ));
        System.out.println("t = " + t.groupByWhitelist(User::getId, Arrays.asList(1, 2)));
    }
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

