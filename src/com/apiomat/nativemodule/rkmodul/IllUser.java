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
import com.apiomat.nativemodule.rkmodul.*;

/**
* Generated default class representing a user in your app 
* 
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
* 
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "RKModul", hooksClassName = "com.apiomat.nativemodule.rkmodul.IllUserHooks",
    isTransient = false,    requiredUserRoleCreate=UserRole.Guest, requiredUserRoleRead=UserRole.User,
    requiredUserRoleWrite=UserRole.Owner, restrictResourceAccess=false,
    allowedRolesCreate={}, allowedRolesRead={},
    allowedRolesWrite={}, allowedRolesGrant={})
public class IllUser extends User
{
    /**
     * Contains the name of the module that this model belongs to
     */
    public static final String MODULE_NAME = "RKModul";
    /**
     * Contains the name of the model
     */
    public static final String MODEL_NAME = "IllUser";
    
    /** class specific attributes */
    private String companyEmail = null;
    private List<com.apiomat.nativemodule.rkmodul.IllnessAlert> listOfIllnessAlters = new ArrayList<com.apiomat.nativemodule.rkmodul.IllnessAlert>();
    /**
     * Protected constructor; to create a new instance, use the createObject() method
     */
    public IllUser ()
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

    public String getCompanyEmail()
    {
         return this.companyEmail;
    }

    public void setCompanyEmail( String arg )
    {
        this.companyEmail = arg;
    }

    public List<com.apiomat.nativemodule.rkmodul.IllnessAlert> getListOfIllnessAlters() 
    {
        if(this.listOfIllnessAlters == null || this.listOfIllnessAlters.size() == 0)
        {
            //this.listOfIllnessAlters = loadReferences("listOfIllnessAlters", com.apiomat.nativemodule.rkmodul.IllnessAlert.class);
            try
            {
                Method m = AbstractClientDataModel.class.getMethod( "loadReferences", String.class,  Class.class );
                this.listOfIllnessAlters =  ( List<com.apiomat.nativemodule.rkmodul.IllnessAlert> ) m.invoke( this, "listOfIllnessAlters", com.apiomat.nativemodule.rkmodul.IllnessAlert.class );
            }
            catch ( NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
        return this.listOfIllnessAlters;
    }

    public void postListOfIllnessAlters( final com.apiomat.nativemodule.rkmodul.IllnessAlert refData )
    {
        addReference( "listOfIllnessAlters", refData );
        this.listOfIllnessAlters.add( refData );
    }

    public void removeListOfIllnessAlters( final com.apiomat.nativemodule.rkmodul.IllnessAlert refData )
    {
        removeReference( "listOfIllnessAlters", refData );
        this.listOfIllnessAlters.remove( refData );
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
        final String _companyEmail = this.companyEmail;
        output.writeBoolean( _companyEmail != null );
        if( _companyEmail != null )
        {
            output.writeString( _companyEmail );
        }
            int listOfIllnessAltersDepth = kryo.getContext( ).get( "listOfIllnessAltersDepth") != null? (int)kryo.getContext( ).get( "listOfIllnessAltersDepth") : 0;
        int listOfIllnessAltersMaxDepth = (int) kryo.getContext( ).get( "maxDepth");
        kryo.getContext( ).put( "listOfIllnessAltersDepth", listOfIllnessAltersDepth +1 );

        if( this.listOfIllnessAlters == null || listOfIllnessAltersDepth >= listOfIllnessAltersMaxDepth)
        {
            output.writeInt(0);
        }
        else
        {
            output.writeInt(this.listOfIllnessAlters.size());
            for(com.apiomat.nativemodule.rkmodul.IllnessAlert _ref : this.listOfIllnessAlters)
            {
                output.writeString( _ref.getModuleName( ) );
                output.writeString( _ref.getModelName( ) );
                _ref.setMethods( this.methods );
                _ref.setResourceMethods( this.resourceMethods );
                _ref.write( kryo, output );
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );
        
        final Request req = (Request)kryo.getContext( ).get( "creq" );
        req.toString( );
        if( input.readBoolean() )
        {
            this.companyEmail = input.readString( );
        }
            final IStaticMethods AOMlistOfIllnessAlters = (IStaticMethods)kryo.getContext( ).get( "AOM" );
        this.listOfIllnessAlters = new ArrayList<>();
        final int listOfIllnessAltersSize = input.readInt();
        for(int i=0; i<listOfIllnessAltersSize; i++)
        {
            final String listOfIllnessAltersModule = input.readString();
            if( "$$INVALID_MODULE_NAME".equals(listOfIllnessAltersModule) == false )
            {
                final String listOfIllnessAltersClass = input.readString();
                com.apiomat.nativemodule.rkmodul.IllnessAlert _listOfIllnessAlters = ( com.apiomat.nativemodule.rkmodul.IllnessAlert ) AOMlistOfIllnessAlters.createObject( kryo.getContext( ).get( "appName").toString( ), listOfIllnessAltersModule, listOfIllnessAltersClass, req );
                _listOfIllnessAlters.read( kryo, input );
                this.listOfIllnessAlters.add( _listOfIllnessAlters );
            }
        }
    }
}
