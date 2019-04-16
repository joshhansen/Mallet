package cc.mallet.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.rmi.dgc.VMID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class VMIDtoUUID {
	public static UUID vmidToUUID(VMID vmid) {
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] hash = md5.digest(vmid.toString().getBytes("UTF-8"));
			
			ByteBuffer buf = ByteBuffer.wrap(hash);
			final long mostSignificantBits = buf.getLong();
			final long leastSignificantBits = buf.getLong();
			
			return new UUID(mostSignificantBits, leastSignificantBits);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
		
	}
}
