import br.ce.wcaquino.taskbackend.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        //cenario
        LocalDate date = LocalDate.of(2030, 1, 1);
        //acao
        boolean result = DateUtils.isEqualOrFutureDate(date);
        //verificacao
        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarFalseParaDatasPassadas() {
        //cenario
        LocalDate date = LocalDate.of(2010, 1, 1);
        //acao
        boolean result = DateUtils.isEqualOrFutureDate(date);
        //verificacao
        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarTrueParaDataAtual() {
        //cenario
        LocalDate date = LocalDate.now();
        //acao
        boolean result = DateUtils.isEqualOrFutureDate(date);
        //verificacao
        Assert.assertTrue(result);
    }

}
