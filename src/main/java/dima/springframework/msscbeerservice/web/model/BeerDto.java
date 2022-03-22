package dima.springframework.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {

   @Id
   @GeneratedValue(generator = "UUID")
   @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
   @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
   private UUID id;

   @Version
   private Integer version;

   @CreationTimestamp
   @Column(updatable = false)
   private OffsetDateTime createdDate;

   @UpdateTimestamp
   private OffsetDateTime lastModifiedDate;

   private String beerName;
   private BeerStyleEnum beerStyle;

   @Column(unique = true)
   private Long upc;

   private BigDecimal price;
   private Integer quantityOnHand;
}
