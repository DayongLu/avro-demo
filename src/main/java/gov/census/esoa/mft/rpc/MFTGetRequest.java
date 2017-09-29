/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package gov.census.esoa.mft.rpc;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MFTGetRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6153552515191901918L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MFTGetRequest\",\"namespace\":\"gov.census.esoa.mft.rpc\",\"fields\":[{\"name\":\"clientId\",\"type\":\"string\"},{\"name\":\"fileName\",\"type\":\"string\"},{\"name\":\"offset\",\"type\":\"long\"},{\"name\":\"length\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<MFTGetRequest> ENCODER =
      new BinaryMessageEncoder<MFTGetRequest>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MFTGetRequest> DECODER =
      new BinaryMessageDecoder<MFTGetRequest>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<MFTGetRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<MFTGetRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<MFTGetRequest>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this MFTGetRequest to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a MFTGetRequest from a ByteBuffer. */
  public static MFTGetRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence clientId;
  @Deprecated public java.lang.CharSequence fileName;
  @Deprecated public long offset;
  @Deprecated public long length;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MFTGetRequest() {}

  /**
   * All-args constructor.
   * @param clientId The new value for clientId
   * @param fileName The new value for fileName
   * @param offset The new value for offset
   * @param length The new value for length
   */
  public MFTGetRequest(java.lang.CharSequence clientId, java.lang.CharSequence fileName, java.lang.Long offset, java.lang.Long length) {
    this.clientId = clientId;
    this.fileName = fileName;
    this.offset = offset;
    this.length = length;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return clientId;
    case 1: return fileName;
    case 2: return offset;
    case 3: return length;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: clientId = (java.lang.CharSequence)value$; break;
    case 1: fileName = (java.lang.CharSequence)value$; break;
    case 2: offset = (java.lang.Long)value$; break;
    case 3: length = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'clientId' field.
   * @return The value of the 'clientId' field.
   */
  public java.lang.CharSequence getClientId() {
    return clientId;
  }

  /**
   * Sets the value of the 'clientId' field.
   * @param value the value to set.
   */
  public void setClientId(java.lang.CharSequence value) {
    this.clientId = value;
  }

  /**
   * Gets the value of the 'fileName' field.
   * @return The value of the 'fileName' field.
   */
  public java.lang.CharSequence getFileName() {
    return fileName;
  }

  /**
   * Sets the value of the 'fileName' field.
   * @param value the value to set.
   */
  public void setFileName(java.lang.CharSequence value) {
    this.fileName = value;
  }

  /**
   * Gets the value of the 'offset' field.
   * @return The value of the 'offset' field.
   */
  public java.lang.Long getOffset() {
    return offset;
  }

  /**
   * Sets the value of the 'offset' field.
   * @param value the value to set.
   */
  public void setOffset(java.lang.Long value) {
    this.offset = value;
  }

  /**
   * Gets the value of the 'length' field.
   * @return The value of the 'length' field.
   */
  public java.lang.Long getLength() {
    return length;
  }

  /**
   * Sets the value of the 'length' field.
   * @param value the value to set.
   */
  public void setLength(java.lang.Long value) {
    this.length = value;
  }

  /**
   * Creates a new MFTGetRequest RecordBuilder.
   * @return A new MFTGetRequest RecordBuilder
   */
  public static gov.census.esoa.mft.rpc.MFTGetRequest.Builder newBuilder() {
    return new gov.census.esoa.mft.rpc.MFTGetRequest.Builder();
  }

  /**
   * Creates a new MFTGetRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MFTGetRequest RecordBuilder
   */
  public static gov.census.esoa.mft.rpc.MFTGetRequest.Builder newBuilder(gov.census.esoa.mft.rpc.MFTGetRequest.Builder other) {
    return new gov.census.esoa.mft.rpc.MFTGetRequest.Builder(other);
  }

  /**
   * Creates a new MFTGetRequest RecordBuilder by copying an existing MFTGetRequest instance.
   * @param other The existing instance to copy.
   * @return A new MFTGetRequest RecordBuilder
   */
  public static gov.census.esoa.mft.rpc.MFTGetRequest.Builder newBuilder(gov.census.esoa.mft.rpc.MFTGetRequest other) {
    return new gov.census.esoa.mft.rpc.MFTGetRequest.Builder(other);
  }

  /**
   * RecordBuilder for MFTGetRequest instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MFTGetRequest>
    implements org.apache.avro.data.RecordBuilder<MFTGetRequest> {

    private java.lang.CharSequence clientId;
    private java.lang.CharSequence fileName;
    private long offset;
    private long length;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(gov.census.esoa.mft.rpc.MFTGetRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fileName)) {
        this.fileName = data().deepCopy(fields()[1].schema(), other.fileName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.offset)) {
        this.offset = data().deepCopy(fields()[2].schema(), other.offset);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.length)) {
        this.length = data().deepCopy(fields()[3].schema(), other.length);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing MFTGetRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(gov.census.esoa.mft.rpc.MFTGetRequest other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fileName)) {
        this.fileName = data().deepCopy(fields()[1].schema(), other.fileName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.offset)) {
        this.offset = data().deepCopy(fields()[2].schema(), other.offset);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.length)) {
        this.length = data().deepCopy(fields()[3].schema(), other.length);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'clientId' field.
      * @return The value.
      */
    public java.lang.CharSequence getClientId() {
      return clientId;
    }

    /**
      * Sets the value of the 'clientId' field.
      * @param value The value of 'clientId'.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder setClientId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.clientId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'clientId' field has been set.
      * @return True if the 'clientId' field has been set, false otherwise.
      */
    public boolean hasClientId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'clientId' field.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder clearClientId() {
      clientId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'fileName' field.
      * @return The value.
      */
    public java.lang.CharSequence getFileName() {
      return fileName;
    }

    /**
      * Sets the value of the 'fileName' field.
      * @param value The value of 'fileName'.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder setFileName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.fileName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'fileName' field has been set.
      * @return True if the 'fileName' field has been set, false otherwise.
      */
    public boolean hasFileName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'fileName' field.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder clearFileName() {
      fileName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'offset' field.
      * @return The value.
      */
    public java.lang.Long getOffset() {
      return offset;
    }

    /**
      * Sets the value of the 'offset' field.
      * @param value The value of 'offset'.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder setOffset(long value) {
      validate(fields()[2], value);
      this.offset = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'offset' field has been set.
      * @return True if the 'offset' field has been set, false otherwise.
      */
    public boolean hasOffset() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'offset' field.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder clearOffset() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'length' field.
      * @return The value.
      */
    public java.lang.Long getLength() {
      return length;
    }

    /**
      * Sets the value of the 'length' field.
      * @param value The value of 'length'.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder setLength(long value) {
      validate(fields()[3], value);
      this.length = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'length' field has been set.
      * @return True if the 'length' field has been set, false otherwise.
      */
    public boolean hasLength() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'length' field.
      * @return This builder.
      */
    public gov.census.esoa.mft.rpc.MFTGetRequest.Builder clearLength() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MFTGetRequest build() {
      try {
        MFTGetRequest record = new MFTGetRequest();
        record.clientId = fieldSetFlags()[0] ? this.clientId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.fileName = fieldSetFlags()[1] ? this.fileName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.offset = fieldSetFlags()[2] ? this.offset : (java.lang.Long) defaultValue(fields()[2]);
        record.length = fieldSetFlags()[3] ? this.length : (java.lang.Long) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MFTGetRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<MFTGetRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MFTGetRequest>
    READER$ = (org.apache.avro.io.DatumReader<MFTGetRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
