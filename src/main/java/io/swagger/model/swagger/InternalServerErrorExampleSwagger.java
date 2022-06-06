package io.swagger.model.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.Objects;

public class InternalServerErrorExampleSwagger {
    /**
     * Get statusCode
     * @return statusCode
     **/
    @Schema(example = "500", description = "")
    private final int statusCode;
    /**
     * Get timestamp
     * @return timestamp
     **/
    @Schema(example = "Mon Jun 06 15:40:11 CEST 2022", description = "")
    private final Date timestamp;
    /**
     * Get message
     * @return message
     **/
    @Schema(example = "Internal server error.", description = "")
    private final String message;

    public InternalServerErrorExampleSwagger(int statusCode, Date timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InternalServerErrorExampleSwagger exampleSwagger = (InternalServerErrorExampleSwagger) o;
        return Objects.equals(this.statusCode, exampleSwagger.statusCode) &&
                Objects.equals(this.timestamp, exampleSwagger.timestamp)&&
                Objects.equals(this.message, exampleSwagger.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, timestamp, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InternalServerErrorExampleSwagger {\n");

        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}