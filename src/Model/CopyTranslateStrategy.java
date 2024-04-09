package Model;

public class CopyTranslateStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveModel destination) {
		destination.setX(source.getX());
		destination.setY(source.getY());
	}
}
