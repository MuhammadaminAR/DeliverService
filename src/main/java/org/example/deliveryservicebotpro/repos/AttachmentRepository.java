package org.example.deliveryservicebotpro.repos;

import org.example.deliveryservicebotpro.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}