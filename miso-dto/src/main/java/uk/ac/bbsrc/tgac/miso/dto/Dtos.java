package uk.ac.bbsrc.tgac.miso.dto;

import java.util.Set;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.google.common.collect.Sets;

import uk.ac.bbsrc.tgac.miso.core.data.QcPassedDetail;
import uk.ac.bbsrc.tgac.miso.core.data.SampleAdditionalInfo;
import uk.ac.bbsrc.tgac.miso.core.data.SampleClass;
import uk.ac.bbsrc.tgac.miso.core.data.Subproject;
import uk.ac.bbsrc.tgac.miso.core.data.TissueOrigin;
import uk.ac.bbsrc.tgac.miso.core.data.TissueType;
import uk.ac.bbsrc.tgac.miso.core.data.impl.QcPassedDetailImpl;
import uk.ac.bbsrc.tgac.miso.core.data.impl.SampleAdditionalInfoImpl;
import uk.ac.bbsrc.tgac.miso.core.data.impl.SampleClassImpl;
import uk.ac.bbsrc.tgac.miso.core.data.impl.SubprojectImpl;
import uk.ac.bbsrc.tgac.miso.core.data.impl.TissueOriginImpl;
import uk.ac.bbsrc.tgac.miso.core.data.impl.TissueTypeImpl;

public class Dtos {

  private static DateTimeFormatter dateTimeFormatter = ISODateTimeFormat.dateTimeNoMillis();

  public static TissueOriginDto asDto(TissueOrigin from) {
    TissueOriginDto dto = new TissueOriginDto();
    dto.setId(from.getTissueOriginId());
    dto.setAlias(from.getAlias());
    dto.setDescription(from.getDescription());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<TissueOriginDto> asTissueOriginDtos(Set<TissueOrigin> from) {
    Set<TissueOriginDto> dtoSet = Sets.newHashSet();
    for (TissueOrigin tissueOrigin : from) {
      dtoSet.add(asDto(tissueOrigin));
    }
    return dtoSet;
  }

  public static TissueOrigin to(TissueOriginDto from) {
    TissueOrigin to = new TissueOriginImpl();
    to.setAlias(from.getAlias());
    to.setDescription(from.getDescription());
    return to;
  }

  public static TissueTypeDto asDto(TissueType from) {
    TissueTypeDto dto = new TissueTypeDto();
    dto.setId(from.getTissueTypeId());
    dto.setAlias(from.getAlias());
    dto.setDescription(from.getDescription());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<TissueTypeDto> asTissueTypeDtos(Set<TissueType> from) {
    Set<TissueTypeDto> dtoSet = Sets.newHashSet();
    for (TissueType tissueOrigin : from) {
      dtoSet.add(asDto(tissueOrigin));
    }
    return dtoSet;
  }

  public static TissueType to(TissueTypeDto from) {
    TissueType to = new TissueTypeImpl();
    to.setAlias(from.getAlias());
    to.setDescription(from.getDescription());
    return to;
  }

  public static SubprojectDto asDto(Subproject from) {
    SubprojectDto dto = new SubprojectDto();
    dto.setId(from.getSubprojectId());
    dto.setAlias(from.getAlias());
    dto.setDescription(from.getDescription());
    dto.setPriority(from.getPriority());
    dto.setParentProjectId(from.getParentProject().getProjectId());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<SubprojectDto> asSubprojectDtos(Set<Subproject> from) {
    Set<SubprojectDto> dtoSet = Sets.newHashSet();
    for (Subproject subproject : from) {
      dtoSet.add(asDto(subproject));
    }
    return dtoSet;
  }

  public static Subproject to(SubprojectDto from) {
    Subproject to = new SubprojectImpl();
    to.setAlias(from.getAlias());
    to.setDescription(from.getDescription());
    to.setPriority(from.getPriority());
    return to;
  }

  public static SampleClassDto asDto(SampleClass from) {
    SampleClassDto dto = new SampleClassDto();
    dto.setId(from.getSampleClassId());
    dto.setAlias(from.getAlias());
    dto.setSampleCategory(from.getSampleCategory());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<SampleClassDto> asSampleClassDtos(Set<SampleClass> from) {
    Set<SampleClassDto> dtoSet = Sets.newHashSet();
    for (SampleClass sampleClass : from) {
      dtoSet.add(asDto(sampleClass));
    }
    return dtoSet;
  }

  public static SampleClass to(SampleClassDto from) {
    SampleClass to = new SampleClassImpl();
    to.setAlias(from.getAlias());
    to.setSampleCategory(from.getSampleCategory());
    return to;
  }

  public static QcPassedDetailDto asDto(QcPassedDetail from) {
    QcPassedDetailDto dto = new QcPassedDetailDto();
    dto.setId(from.getQcPassedDetailId());
    dto.setStatus(from.getStatus());
    dto.setDescription(from.getDescription());
    dto.setNoteRequired(from.getNoteRequired());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<QcPassedDetailDto> asQcPassedDetailDtos(Set<QcPassedDetail> from) {
    Set<QcPassedDetailDto> dtoSet = Sets.newHashSet();
    for (QcPassedDetail qcPassedDetail : from) {
      dtoSet.add(asDto(qcPassedDetail));
    }
    return dtoSet;
  }

  public static QcPassedDetail to(QcPassedDetailDto from) {
    QcPassedDetail to = new QcPassedDetailImpl();
    to.setStatus(from.getStatus());
    to.setDescription(from.getDescription());
    to.setNoteRequired(from.isNoteRequired());
    return to;
  }

  public static SampleAdditionalInfoDto asDto(SampleAdditionalInfo from) {
    SampleAdditionalInfoDto dto = new SampleAdditionalInfoDto();
    dto.setId(from.getSampleAdditionalInfoId());
    dto.setPassageNumber(from.getPassageNumber());
    dto.setTimesReceived(from.getTimesReceived());
    dto.setCreatedById(from.getCreatedBy().getUserId());
    dto.setCreationDate(dateTimeFormatter.print(from.getCreationDate().getTime()));
    dto.setUpdatedById(from.getUpdatedBy().getUserId());
    dto.setLastUpdated(dateTimeFormatter.print(from.getLastUpdated().getTime()));
    return dto;
  }

  public static Set<SampleAdditionalInfoDto> asSampleAdditionalInfoDtos(Set<SampleAdditionalInfo> from) {
    Set<SampleAdditionalInfoDto> dtoSet = Sets.newHashSet();
    for (SampleAdditionalInfo sampleAdditionalInfo : from) {
      dtoSet.add(asDto(sampleAdditionalInfo));
    }
    return dtoSet;
  }

  public static SampleAdditionalInfo to(SampleAdditionalInfoDto from) {
    SampleAdditionalInfo to = new SampleAdditionalInfoImpl();
    to.setPassageNumber(from.getPassageNumber());
    to.setTimesReceived(from.getTimesReceived());
    return to;
  }

}
