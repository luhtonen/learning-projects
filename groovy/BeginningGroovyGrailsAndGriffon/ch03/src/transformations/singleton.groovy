package transformations

// Singleton Java style
public class T {
    public static final T instance = new T()
    private T() {}
}

// Singleton using transformation
@Singleton class TT {}
assert TT.instance != null

// Singleton with Lazy loading
@Singleton(lazy = true) class TTT {}
