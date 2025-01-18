import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(!true);
        Assert.assertEquals(0.51, 0.51, 0.1);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        //comparando tipos primitivos
        int i = 5;
        Integer i2 = 5;

        Assert.assertEquals(Integer.valueOf(i), i2);
        //Assert.assertEquals(1, i2); // não podemos fazer essa comparação devido ao tipo
        Assert.assertEquals(i, i2.intValue());


        Assert.assertEquals("bola", "bola");
        //não passa Assert.assertEquals("bola", "Bola");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario usuario = new Usuario("Paulo");
        Usuario usuario2 = new Usuario("Paulo");
        Usuario usuario3 = null;

        //Esta assertiva só funciona devido ao equal e hash code
        Assert.assertEquals(usuario, usuario2);

        //Assertiva de instancia
        Assert.assertSame(usuario, usuario);
        //representam a mesma instancia
        Assert.assertSame(usuario3, usuario3);

        //Verficando se objetoe está nulo
        Assert.assertTrue(usuario3 == null);
        Assert.assertNull(usuario3);

        //negações
        Assert.assertNotEquals("bola", "casa");
        Assert.assertNotSame(usuario2, usuario);
        Assert.assertNotNull(usuario2);


    }
}
