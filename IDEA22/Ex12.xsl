<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/pointsList">
        <table border="1"><xsl:apply-templates/></table>
    </xsl:template>

    <xsl:template match="/pointsList/point">
        <tr><xsl:apply-templates/></tr>
        <xsl:value-of select="normalize-space()"></xsl:value-of>
    </xsl:template>

    <xsl:template match="/pointsList/point/cm">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/pointsList/point/mm">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/pointsList/point/px">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

</xsl:stylesheet>