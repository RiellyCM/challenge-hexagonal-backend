package io.devpass.creditcard.infrastructure

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.CreditCardService
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanGenerator {

    @Bean
    fun creditCardRepository(): ICreditCardDAO {
        TODO()
    }

    @Bean
    fun creditCardServiceAdapter(
        creditCardRepository: ICreditCardDAO,
    ): ICreditCardServiceAdapter {
        return CreditCardService(creditCardRepository)
    }
}
