package com.lumiradx;

import java.io.Serializable;

/**
 * Centralized Message Object to be passed  between Publisher and Subscriber
 */
public class LumiraMessage implements Serializable
{
    private String carePlanId;
    private String patientIdentifier;
    private String organizationId;
    private String text;

    public LumiraMessage()
    {
    }

    public LumiraMessage(String text, String carePlanId, String patientIdentifier, String organizationId)
    {
        this.text = text;
        this.carePlanId = carePlanId;
        this.patientIdentifier = patientIdentifier;
        this.organizationId = organizationId;
    }

    /**
     * Get text info
     *
     * @return text
     */
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * Get Care Plan Identifier
     *
     * @return carePlanId
     */
    public String getCarePlanId()
    {
        return carePlanId;
    }

    public void setCarePlanId(String carePlanId)
    {
        this.carePlanId = carePlanId;
    }

    /**
     * Get Patient Identifier
     *
     * @return patientId
     */
    public String getPatientIdentifier()
    {
        return patientIdentifier;
    }

    public void setPatientIdentifier(String patientIdentifier)
    {
        this.patientIdentifier = patientIdentifier;
    }

    /**
     * Get organization Id
     *
     * @return organizationId
     */
    public String getOrganizationId()
    {
        return organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof LumiraMessage))
            return false;

        LumiraMessage that = (LumiraMessage) o;

        if (getCarePlanId() != null ? !getCarePlanId().equals(that.getCarePlanId()) : that.getCarePlanId() != null)
            return false;
        if (getPatientIdentifier() != null ?
            !getPatientIdentifier().equals(that.getPatientIdentifier()) :
            that.getPatientIdentifier() != null)
            return false;
        if (getOrganizationId() != null ?
            !getOrganizationId().equals(that.getOrganizationId()) :
            that.getOrganizationId() != null)
            return false;
        return getText() != null ? getText().equals(that.getText()) : that.getText() == null;

    }

    @Override
    public int hashCode()
    {
        int result = getCarePlanId() != null ? getCarePlanId().hashCode() : 0;
        result = 31 * result + (getPatientIdentifier() != null ? getPatientIdentifier().hashCode() : 0);
        result = 31 * result + (getOrganizationId() != null ? getOrganizationId().hashCode() : 0);
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("LumiraMessage{").append('\n');
        sb.append("carePlanId=").append(carePlanId).append('\n');
        sb.append(", patientIdentifier=").append(patientIdentifier).append('\n');
        sb.append(", organizationId=").append(organizationId).append('\n');
        sb.append(", text=").append(text).append('\n');
        sb.append('}').append('\n').append('\n');
        return sb.toString();
    }
}
