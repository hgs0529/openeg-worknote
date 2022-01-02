package open.eg.worknote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class WorknoteDto {

	private String userid;
	private String startTime;
	private String endTime;
	private String startLocation;
	private String endLocation;
}
