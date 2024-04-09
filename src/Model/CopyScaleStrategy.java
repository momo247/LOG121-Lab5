package Model;

public class CopyScaleStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveModel destination) {
		destination.setScale(source.getScale());
	}
}
