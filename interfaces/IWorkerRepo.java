package interfaces;

import java.lang.*;
import entity.*;

public interface IWorkerRepo
{
	public void addWorker(Worker w);
	public void deleteWorker(String workerId);
	public Worker searchWorker(String workerId);
	public void updateWorkerInfo(Worker w);
	public String[][] getWorkerUpdate();

}