package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "car_option")

//@Embeddable
//@ManyToMany
//@JoinTable(name = "public.car")

public class CarOption implements Serializable {

    @Id
    private int Id;
//

//   @ManyToMany
//    @JoinTable(name="public.car")
//    @JoinColumn(name = "id")
  //  @JoinTable(name="public.car",joinColumns = @JoinColumn(name = "id"),
  //          inverseJoinColumns =  @JoinColumn(name = "car_id"))


//@EmbeddedId
//   @Id
   @Column(name="car_id")
   // @AttributeOverride(name="car",column = @Column(name="id"))

   //@ManyToOne
    //@JoinTable(name="public.car")
//    @JoinColumn(name = "id")
//      @JoinTable(name="public.car",joinColumns = @JoinColumn(name = "id"),
//             inverseJoinColumns =  @JoinColumn(name = "car_id"))
   // @JoinColumn(name = "id")
//     @JoinTable(name="public.car",joinColumns = @JoinColumn(name = "id"),
  //          inverseJoinColumns =  @JoinColumn(name = "car_id"))
    private String carId;


  @Column(name="option_id")
 //   (mappedBy="option")
   // @OrderBy("id")
  //@OneToMany
  //@EmbeddedId
   //@JoinTable(name="public.option",joinColumns = @JoinColumn(name = "id"),
     //      inverseJoinColumns =  @JoinColumn(name = "option_id"))
     //@JoinColumn(name = "option_id")
    private String optionId;

   // private Long id;

    public CarOption(){

    }

    public CarOption(int id, String carId, String optionId) {

        this.Id = id;
        this.carId = carId;
        this.optionId = optionId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = Id;
    }


    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOption carOption = (CarOption) o;
        return Objects.equals(carId, carOption.carId) && Objects.equals(optionId, carOption.optionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, optionId);
    }

    @Override
    public String toString() {
        return "CarOption{" +
                "carId='" + carId + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }

    //public void setId(Long id) {
    //    this.id = id; }

    //public Long getId() { return id;}
}
