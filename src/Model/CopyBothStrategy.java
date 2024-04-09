package Model;

public class CopyBothStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveModel destination) {
		destination.setScale(source.getScale());
		destination.setX(source.getX());
		destination.setY(source.getY());
	}
}
