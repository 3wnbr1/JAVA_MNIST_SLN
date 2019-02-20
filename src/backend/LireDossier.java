package backend;


import java.io.File;
import java.util.LinkedList;

public class LireDossier {
	private String[] nomFichiers;
	private LinkedList<String> lNoms;

	public String[] getNomFichiers() {
		return nomFichiers;
	}
	
	

	public LireDossier(String nomDossier) {
		lNoms= new LinkedList<String>();
		findFiles(nomDossier);
		nomFichiers=lNoms.toArray(new String[lNoms.size()]);	
	}

	private void findFiles(String directoryPath) {
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			System.out.println("Le fichier/repertoire '" + directoryPath + "' n'existe pas");
		} else if (!directory.isDirectory()) {
			System.out.println("Le chemin '" + directoryPath + "' correspond a un fichier et non a un repertoire");
		} else {
			File[] subfiles = directory.listFiles();
			String message = "Le repertoire '" + directoryPath + "' contient " + subfiles.length + " fichier"
					+ (subfiles.length > 1 ? "s" : "");
			System.out.println(message);
			for (int i = 0; i < subfiles.length; i++) {
				lNoms.add(subfiles[i].getName());
			}
		}
	}
	
	

}
