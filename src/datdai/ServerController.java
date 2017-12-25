package datdai;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController implements ServerService {
	private ServerView view;
	private int serverPost = 1996;
	private ServerSocket myServer;
	private Socket clientSocket;
	public ServerController(ServerView view) {
		this.view = view;
		openServer(serverPost);
		while(true) {
			listenning();
		}
	}
	public void openServer(int portNumber) {
		try {
			myServer = new ServerSocket(portNumber);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void listenning() {
		try {
			clientSocket = myServer.accept();
			ObjectInputStream ios = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			while(true) {
				Object choose = ios.readObject();
				if(choose instanceof Integer) {
					if((Integer) choose == 5) {
						LoDat ld = (LoDat) ios.readObject();
						System.out.println(ld.toString());
						oos.writeObject(addLoDat(ld)); 
					}
					if((Integer) choose == 2){
						int machulo = (Integer)(ios.readObject());
						System.out.println("machulo Server: "+machulo);
						oos.writeObject((ArrayList<LoDat>)getLoDatByMaChuLo(machulo));
						System.out.println("Writed");
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public boolean addLoDat(LoDat lodat) {
		 	ArrayList<LoDat> all = readfile();
		 	all.removeAll(all);
	        all.add(lodat);
	        writeFile(all);
	        return true;
	}
	private void writeFile(ArrayList lodat) {
		try {
			ObjectOutputStream out = new  ObjectOutputStream(new FileOutputStream("Contact3.dat"));
			out.writeObject(lodat);
			out.flush();
			out.close();
		} catch (Exception e) {
			
		}
	}
	private ArrayList<LoDat> readfile(){
		ArrayList<LoDat> all = new ArrayList<>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Contact3.dat"));
			all = (ArrayList<LoDat>) in.readObject();
			in.close();
		} catch (NullPointerException nullPoint) {
			return null;
		}catch (Exception e) {
			e.getMessage();
		}
		return all;
	}

	@Override
	public ArrayList<LoDat> getLoDatByMaChuLo(int machulo) {
		ArrayList<LoDat> all = readfile();
		ArrayList<LoDat> allnew = new ArrayList<>();
		System.out.println("all size Server: " +all.get(0).toString());
		for (LoDat lodat : all) {
			if(lodat.getMachulo() == machulo) {
				allnew.add(lodat); 
			}
		}
		
		return allnew;
	}

	@Override
	public LoDat getLoDatMoiByMaChuLo(int machulo) {
		ArrayList<LoDat> all = readfile();
		LoDat ld = new LoDat();
		for (LoDat lodat : all) {
			if(lodat.getMachulo() == machulo && lodat.getStatus() == 0) {
				ld = lodat;
			}
		}
		return ld;
	}

	@Override
	public boolean updateChuLo(int machulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSCay(int machulo, int malo, double Scay) {
		// TODO Auto-generated method stub
		return false;
	}

}
