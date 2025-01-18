package br.com.odevpedro.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.*;


public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public  void testeLocacao() throws Exception {

        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 1, 5.0);


        Locacao locacao = service.alugarFilme(usuario, filme);
        error.checkThat(locacao.getValor(), is((5.0)));
        error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
    }

    //elegante - informamos ao teste que existe uma excecao sendo esperada
    @Test(expected=Exception.class)
    public void  testandoLocacao_FilmeSemEstoque() throws Exception {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);

        service.alugarFilme(usuario, filme);

    }

    //robusta - uma forma muito interessante, esperamos a mensagem especifica
    @Test
    public void  testandoLocacao_FilmeSemEstoque_2() {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);

        try {
            service.alugarFilme(usuario, filme);
            Assert.fail("Deveria ter lançado uma execao");
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Filme sem estoque"));
        }

    }
        //forma nova
        @Test
        public void  testandoLocacao_FilmeSemEstoque_3() throws Exception {
            LocacaoService service = new LocacaoService();
            Usuario usuario = new Usuario("Usuário 1");
            Filme filme = new Filme("Filme 1", 0, 5.0);

            exception.expect(Exception.class);
            exception.expectMessage("Filme sem estoque");

            service.alugarFilme(usuario, filme);



        }

    }

    
