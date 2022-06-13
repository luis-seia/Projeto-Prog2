package BaseDados;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.info.users.Responsavel;

public class BaseDadosUtilizador {

	public final static String path = "src\\BaseDados\\lista_Utilizadores.txt";

	public static HashMap<String, Responsavel> map = new HashMap<String, Responsavel>();

	public static void salvarUtilizador(String senha, Responsavel responsavel) {
		BaseDadosUtilizador.map.put(senha, responsavel);
		System.out.println("\n\tInformacoes salvas temporariamente!");
	}

	public static boolean salvarProdutoPermanentemente() {
		boolean salvo = false;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		// Escrita em ficheiros
		try {

			fos = new FileOutputStream(path, true);
			// O argumento true serve para indicar que nao sobrescrever o conteudo do
			// ficheiro
			bos = new BufferedOutputStream(fos);

			Set<Map.Entry<String, Responsavel>> set = map.entrySet();
			for (Map.Entry<String, Responsavel> resp : set) {

				String texto = "<" + resp.getKey() + "|" + resp.getValue() + " \n";

				byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
				bos.write(textoByte);
			}

			bos.flush();
			bos.close();
			fos.close();
			salvo = true;

		} catch (Exception e) {
			salvo = false;
			System.out.print("ERRO AO SALVAR: ");
			e.printStackTrace();
		} finally {

		}
		return salvo;
	}

	public static boolean salvarProdutoPermanentemente(HashMap<String, Responsavel> novo_map) {

		boolean salvo = false;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		// Escrita em ficheiros
		try {

			fos = new FileOutputStream(path);
			// Agora vamos obrescrever o conteudo do ficheiro
			// Porque o nosso novo_map tem toda informacao anterior
			// e o produto com os detalhes alterados
			bos = new BufferedOutputStream(fos);

			Set<Map.Entry<String, Responsavel>> novo_set = novo_map.entrySet();
			for (Map.Entry<String, Responsavel> prod : novo_set) {

				String texto = "<" + prod.getKey() + "|" + prod.getValue() + " \n";

				byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
				bos.write(textoByte);
			}

			bos.flush();
			bos.close();
			fos.close();
			salvo = true;

		} catch (Exception e) {
			salvo = false;
			System.out.print("ERRO AO SALVAR: ");
			e.printStackTrace();
		}

		return salvo;
	}
}