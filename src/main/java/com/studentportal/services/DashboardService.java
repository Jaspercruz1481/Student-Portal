package com.studentportal.services;

import com.studentportal.models.dto.DashboardDto;

public interface DashboardService {
    DashboardDto getDashboard(Long studentId);
}
