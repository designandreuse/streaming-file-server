package daggerok.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import daggerok.client.model.audit.AbstractAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import static daggerok.client.model.FileType.FILE;
import static daggerok.service.util.FileItemUtil.NORMAL_FILE_SIZE;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileItem extends AbstractAuditEntity {
  private static final long serialVersionUID = -6455969576919191029L;

  @NonNull private String path;
  @NonNull private String prettySize;
  @NonNull private Long size;
  @NonNull private FileType fileType;
  private String filename;
  private String extension;
  private String owner;
  private Long version;

  public boolean isFile() {
    return FILE.equals(this.fileType);
  }

  public boolean isLarge() {
    return this.size > NORMAL_FILE_SIZE;
  }
}
