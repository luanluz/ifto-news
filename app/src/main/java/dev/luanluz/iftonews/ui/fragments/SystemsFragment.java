package dev.luanluz.iftonews.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.luanluz.iftonews.R;
import dev.luanluz.iftonews.ui.adapters.SystemsGridAdapter;

public class SystemsFragment extends Fragment {
    private final String[][] systemsIFTO = {
        {"Webmail", "Sistemas Administrativos", "http://www.gmail.com.br/"},
        {"SEI", "Sistemas Administrativos", "http://sei.ifto.edu.br/"},
        {"SUAP", "Sistemas Administrativos", "https://suap.ifto.edu.br/"},
        {"SUAP Mobile", "Sistemas Administrativos", "https://play.google.com/store/apps/details?id=br.edu.ifto.suap.mobile"},
        {"Sistemas Integrados", "Sistemas Administrativos", "https://si.ifto.edu.br/"},
        {"Conferência Web", "Sistemas Administrativos", "https://conferenciaweb.rnp.br/"},
        {"Gerenciamento de Projetos", "Sistemas Administrativos", "http://redmine.ifto.edu.br/projects"},
        {"PAAI ou Remoção", "Sistemas Administrativos", "https://si.ifto.edu.br/"},
        {"Compras", "Sistemas Administrativos", "http://apps.ifto.edu.br/compras/login.php"},
        {"Mapa de Risco", "Sistemas Administrativos", "http://apps.ifto.edu.br/mapa/login.php"},
        {"FORDI", "Sistemas Administrativos", "https://ifto.plataformafor.mec.gov.br/"},
        {"Denúncia, Elogio, Reclamação e Outros", "Ouvidoria | Fala.BR", "https://falabr.cgu.gov.br/publico/Manifestacao/SelecionarTipoManifestacao.aspx?ReturnUrl=%2f"},
        {"Realizar Inscrição - SI", "Eventos do IFTO", "https://si.ifto.edu.br/evento/inscricoes/"},
        {"Realizar Inscrição - SUAP", "Eventos do IFTO", "https://suap.ifto.edu.br/eventos/inscricao_publica/"},
        {"Emitir Certificado", "Eventos do IFTO", "https://si.ifto.edu.br/evento/certificados/"},
        {"Sophia Biblioteca", "Sistemas Acadêmicos", "https://biblioteca.ifto.edu.br/"},
        {"Ficha Catalográfica", "Sistemas Acadêmicos", "https://si.ifto.edu.br/fichacatalografica/"},
        {"Certificados", "Sistemas Acadêmicos", "https://si.ifto.edu.br/evento/certificados"},
        {"Moodle", "Sistemas Acadêmicos", "https://moodle.ifto.edu.br/moodle/"},
    };

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_systems_cards, container, false);

        GridView gridSystemsIFTO = view.findViewById(R.id.gridSystemsIFTO);
        gridSystemsIFTO.setAdapter(new SystemsGridAdapter(requireContext(), systemsIFTO));

        gridSystemsIFTO.setOnItemClickListener((adapterView, viewItem, position, l) -> {
            int urlPosition = 2;
            String url = systemsIFTO[position][urlPosition];

            openWebPage(url);
        });

        return view;
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}