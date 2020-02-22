package org.jeecg;

import com.elnido.modules.masterdata.util.ElnidoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.CoreMatchers.is;

@ActiveProfiles("unittest")
@Slf4j
public class ElnidoUtilTest {


    @Test
    public void a_test_handle_jeecg_fuzzy_search_input() {
        String inputWithOutAsterisk = "fuzzyserch";
        String result0 = ElnidoUtil.handleJeecgFuzzySearchString(inputWithOutAsterisk);
        Assert.assertThat(result0, is(inputWithOutAsterisk));

        String inputWithOutLeftAsterisk = "*fuzzyserch";
        String result1 = ElnidoUtil.handleJeecgFuzzySearchString(inputWithOutLeftAsterisk);
        Assert.assertThat(result1, is(inputWithOutAsterisk));

        String inputWithOutRightAsterisk = "fuzzyserch*";
        String result2 = ElnidoUtil.handleJeecgFuzzySearchString(inputWithOutRightAsterisk);
        Assert.assertThat(result2, is(inputWithOutAsterisk));

        String inputWithOutBothAsterisk = "*fuzzyserch*";
        String result3 = ElnidoUtil.handleJeecgFuzzySearchString(inputWithOutBothAsterisk);
        Assert.assertThat(result3, is(inputWithOutAsterisk));
    }
}
