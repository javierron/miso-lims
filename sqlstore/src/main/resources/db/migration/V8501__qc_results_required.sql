ALTER TABLE SampleQC MODIFY COLUMN results decimal(16,10) NOT NULL;
ALTER TABLE LibraryQC MODIFY COLUMN results decimal(16,10) NOT NULL;
ALTER TABLE PoolQC MODIFY COLUMN results decimal(16,10) NOT NULL;
ALTER TABLE ContainerQC MODIFY COLUMN results decimal(16,10) NOT NULL;