package core.IO;

/**
 * @author Rémi GIDON
 */
public interface Callbackable<V> {

    public void call(V msg);

}
