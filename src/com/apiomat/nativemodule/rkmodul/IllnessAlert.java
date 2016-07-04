/*
 * Copyright (c) 2011 - 2016, Apinauten GmbH
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this 
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.apiomat.nativemodule.rkmodul;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.apiomat.nativemodule.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


import com.apiomat.nativemodule.basics.*;

/**
* Generated class for your IllnessAlert data model 
* 
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
* 
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "RKModul", hooksClassName = "com.apiomat.nativemodule.rkmodul.IllnessAlertHooks",
    isTransient = false,    requiredUserRoleCreate=UserRole.User, requiredUserRoleRead=UserRole.User,
    requiredUserRoleWrite=UserRole.Owner, restrictResourceAccess=false,
    allowedRolesCreate={}, allowedRolesRead={},
    allowedRolesWrite={}, allowedRolesGrant={})
public class IllnessAlert extends AbstractClientDataModel implements IModel<IllnessAlert>
{
    /**
     * Contains the name of the module that this model belongs to
     */
    public static final String MODULE_NAME = "RKModul";
    /**
     * Contains the name of the model
     */
    public static final String MODEL_NAME = "IllnessAlert";
    
    /** class specific attributes */
    private Date enddate = null;
    private String illnessEmail = null;
    @StaticData( type = com.apiomat.nativemodule.StaticData.Type.Image )
    private String recieptURL;
    private Date startdate = null;
    /**
     * Protected constructor; to create a new instance, use the createObject() method
     */
    public IllnessAlert ()
    {}
    
    /**
     * Returns the name of the module where this class belongs to
     */
    @Override
    public String getModuleName( )
    {
        return MODULE_NAME;
    }
    
    /**
     * Returns the name of the model
     */
    @Override
    public String getModelName( )
    {
        return MODEL_NAME;
    }

    public Date getEnddate()
    {
         return this.enddate;
    }

    public void setEnddate( Date arg )
    {
        this.enddate = arg;
    }

    public String getIllnessEmail()
    {
         return this.illnessEmail;
    }

    public void setIllnessEmail( String arg )
    {
        this.illnessEmail = arg;
    }

    public String getRecieptURL( )
    {
        String url;
        url = this.recieptURL;
        return url;
    }

    public byte[] loadReciept( )
    {
        String resUrl = getRecieptURL();
        return loadResource(resUrl);
    }

    public String getRecieptURL( String apiKey, String system, int width, int height, 
        String backgroundColorAsHex, Double alpha, String format )
    {
        final StringBuffer additionalParameters = new StringBuffer(".img?apiKey=" + apiKey + "&system=" 
            + system + "&width=" + width + "&height=" + height);
        if(backgroundColorAsHex != null) 
        {
            additionalParameters.append("&bgcolor=" + backgroundColorAsHex);
        }
        if(alpha != null)
        {
            additionalParameters.append("&alpha=" + alpha);
        }
        if(format != null)
        {
            additionalParameters.append("&format=" + format);
        }
        return getRecieptURL( ) + additionalParameters;
    }

    public byte[] loadReciept( String apiKey, String system, int width, int height, 
        String backgroundColorAsHex, Double alpha, String format )
    {
        final String resUrl = getRecieptURL( apiKey, system, width, height, 
            backgroundColorAsHex, alpha, format );
        return loadResource(resUrl);
    }

    public void setRecieptURL( String url ) 
    {
        this.recieptURL = url;
    }

    public String postReciept( byte[] data , String fileName, String format )
    {
        String url = saveResource( data, true, fileName, format );
        setRecieptURL( url );
        return url;
    }

    public Date getStartdate()
    {
         return this.startdate;
    }

    public void setStartdate( Date arg )
    {
        this.startdate = arg;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
        output.writeLong( this.enddate == null ? 0 : this.enddate.getTime() );
        final String _illnessEmail = this.illnessEmail;
        output.writeBoolean( _illnessEmail != null );
        if( _illnessEmail != null )
        {
            output.writeString( _illnessEmail );
        }
        final String _reciept = this.recieptURL;
        output.writeBoolean( _reciept != null );
        if( _reciept != null )
        {
            output.writeString( _reciept );
        }
        output.writeLong( this.startdate == null ? 0 : this.startdate.getTime() );
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );
        
        final Request req = (Request)kryo.getContext( ).get( "creq" );
        req.toString( );
        final long _enddate = input.readLong();
        this.enddate = _enddate == 0 ? null : new Date(_enddate);
        if( input.readBoolean() )
        {
            this.illnessEmail = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.recieptURL = input.readString();
        }
        final long _startdate = input.readLong();
        this.startdate = _startdate == 0 ? null : new Date(_startdate);
    }
}
