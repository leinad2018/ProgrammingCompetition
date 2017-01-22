package generalPage;

public class UpdateThread implements Runnable {

	private GeneralWindow toUpdate;
	
	public UpdateThread(GeneralWindow toUpdate) {
		this.toUpdate=toUpdate;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			toUpdate.softContentUpdate();
		}
	}

}
