package datdai;

import java.util.ArrayList;

public interface ServerService {
	public boolean addLoDat(LoDat lodat);
	public ArrayList<LoDat> getLoDatByMaChuLo(int machulo);
	public LoDat getLoDatMoiByMaChuLo(int machulo);
	public boolean updateChuLo(int machulo);
	public boolean updateSCay(int machulo,int malo, double Scay);

}
