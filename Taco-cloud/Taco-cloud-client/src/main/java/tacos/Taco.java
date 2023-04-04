package tacos;

import java.util.Date;
import java.util.List;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Taco {
	private Long id;
	private String name;
	private Date createdAt;
	private List<Ingredient> ingredients;
}
